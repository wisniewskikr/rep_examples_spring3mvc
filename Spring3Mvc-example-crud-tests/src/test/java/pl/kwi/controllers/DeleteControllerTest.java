package pl.kwi.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.DeleteCommand;
import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

public class DeleteControllerTest {
	
	private DeleteController controller;
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = mock(UserService.class);
		
		controller = new DeleteController();
		controller.setUserService(userService);
	}

	@Test
	public void displayPage() {
		
		UserEntity user = new UserEntity("User 1");
		when(userService.readUser(Mockito.anyLong())).thenReturn(user);
		
		DeleteCommand command = new DeleteCommand();
		
		ModelAndView modelAndView = controller.displayPage(command, null, null, null);
		
		assertEquals("deleteJsp", modelAndView.getViewName());
		assertEquals("User 1", command.getName());
		
	}
	
	@Test
	public void handleDeleteButton() {
		
		DeleteCommand command = new DeleteCommand();
		
		ModelAndView modelAndView = controller.handleDeleteButton(command, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());			
		
	}
	
	@Test
	public void handleBackButton() {
		
		ModelAndView modelAndView = controller.handleBackButton(null, null, null);
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/table/", redirectView.getUrl());	
		
	}

}
