package pl.kwi.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.CreateCommand;
import pl.kwi.services.UserService;

public class CreateControllerTest {
	
	private CreateController controller;
	private UserService userService;
	private BindingResult bindingResult;

	@Before
	public void setUp() throws Exception {
		userService = mock(UserService.class);
		bindingResult = mock(BindingResult.class);
		
		controller = new CreateController();
		controller.setUserService(userService);
	}

	@Test
	public void displayPage() {
		
		ModelAndView modelAndView = controller.displayPage(null, null, null);
		
		assertEquals("createJsp", modelAndView.getViewName());
		
	}
	
	@Test
	public void handleCreateButton() {
		
		when(bindingResult.hasErrors()).thenReturn(false);
		CreateCommand command = new CreateCommand();
		
		ModelAndView modelAndView = controller.handleCreateButton(command, bindingResult, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());		
		
	}
	
	@Test
	public void handleCreateButton_withError() {
		
		when(bindingResult.hasErrors()).thenReturn(true);
		CreateCommand command = new CreateCommand();
		
		ModelAndView modelAndView = controller.handleCreateButton(command, bindingResult, null, null);
		
		assertEquals("createJsp", modelAndView.getViewName());	
		
	}
	
	@Test
	public void handleBackButton() {
		
		ModelAndView modelAndView = controller.handleBackButton(null, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());	
		
	}

}
