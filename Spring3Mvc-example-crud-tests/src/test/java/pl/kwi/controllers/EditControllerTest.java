package pl.kwi.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.EditCommand;
import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

public class EditControllerTest {
	
	private EditController controller;
	private UserService userService;
	private BindingResult bindingResult;

	@Before
	public void setUp() throws Exception {
		userService = mock(UserService.class);
		bindingResult = mock(BindingResult.class);
		
		controller = new EditController();
		controller.setUserService(userService);
	}

	@Test
	public void displayPage() {
		
		UserEntity user = new UserEntity("User 1");
		when(userService.readUser(Mockito.anyLong())).thenReturn(user);
		
		EditCommand command = new EditCommand();
		
		ModelAndView modelAndView = controller.displayPage(command, null, null, 1L);
		
		assertEquals("editJsp", modelAndView.getViewName());
		assertEquals(Long.valueOf(1L), command.getId());
		assertEquals("User 1", command.getName());
		
	}
	
	@Test
	public void handleUpdateButton() {
		
		when(bindingResult.hasErrors()).thenReturn(false);
		EditCommand command = new EditCommand();
		
		ModelAndView modelAndView = controller.handleUpdateButton(command, bindingResult, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());	
		
	}
	
	@Test
	public void handleUpdateButton_withError() {
		
		UserEntity user = new UserEntity("User 1");
		when(userService.readUser(Mockito.anyLong())).thenReturn(user);
		
		when(bindingResult.hasErrors()).thenReturn(true);
		EditCommand command = new EditCommand();
		command.setId(1L);
		
		ModelAndView modelAndView = controller.handleUpdateButton(command, bindingResult, null, null);
		
		assertEquals("editJsp", modelAndView.getViewName());
		assertEquals(Long.valueOf(1L), command.getId());
		assertEquals("User 1", command.getName());
		
	}
	
	@Test
	public void handleBackButton() {
		
		ModelAndView modelAndView = controller.handleBackButton(null, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());	
		
	}

}
