package pl.kwi.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.InputCommand;
import pl.kwi.services.NameService;

public class InputControllerTest {
	
	
	private InputController controller;
	private NameService nameService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BindingResult bindingResult;
	

	@Before
	public void setUp() throws Exception {
		nameService = mock(NameService.class);
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		bindingResult = mock(BindingResult.class);
		
		controller = new InputController();
		controller.setNameService(nameService);
	}

	@Test
	public void displayPage() {
		
		InputCommand command = new InputCommand();
		
		ModelAndView mav = controller.displayPage(command, request, response);
		
		assertEquals("inputJsp", mav.getViewName());
		
	}
	
	@Test
	public void handleButtonOk() {
		
		InputCommand command = new InputCommand();
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		
		ModelAndView mav = controller.handleButtonOk(command, bindingResult, request, response);
		
		assertEquals("/output", ((RedirectView)mav.getView()).getUrl());
		
	}
	
	@Test
	public void handleButtonOk_has_validation_errors() {
		
		InputCommand command = new InputCommand();
		Mockito.when(bindingResult.hasErrors()).thenReturn(true);
		
		ModelAndView mav = controller.handleButtonOk(command, bindingResult, request, response);
		
		assertEquals("inputJsp", mav.getViewName());
		
	}

}
