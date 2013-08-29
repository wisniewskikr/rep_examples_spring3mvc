package pl.kwi.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.TableCommand;
import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

public class TableControllerTest {
	
	private TableController controller;
	private UserService userService;
	private BindingResult bindingResult;

	@Before
	public void setUp() throws Exception {
		userService = mock(UserService.class);
		bindingResult = mock(BindingResult.class);
		
		controller = new TableController();
		controller.setUserService(userService);
	}

	@Test
	public void displayPage() {
		
		List<UserEntity> users = new ArrayList<UserEntity>();
		users.add(new UserEntity("User1"));
		users.add(new UserEntity("User2"));		
		users.add(new UserEntity("User3"));		
		Mockito.when(userService.getUserList()).thenReturn(users);
		
		TableCommand command = new TableCommand();
		
		ModelAndView modelAndView = controller.displayPage(command, null, null);
		
		assertEquals(3, command.getUsers().size());
		assertEquals("tableJsp", modelAndView.getViewName());

	}
	
	@Test
	public void handleTableAction_create() throws Exception {
		
		ModelAndView modelAndView = controller.handleTableAction(null, null, null, null, "create");
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/create/", redirectView.getUrl());
		
	}
	
	@Test
	public void handleTableAction_view() throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		TableCommand command = new TableCommand();
		command.setSelectedUsersIds(list);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "view");
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/view/1", redirectView.getUrl());
		
	}
	
	@Test
	public void handleTableAction_viewWithError() throws Exception {
		
		TableCommand command = new TableCommand();
		
		when(bindingResult.hasErrors()).thenReturn(true);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "view");
		
		assertEquals("tableJsp", modelAndView.getViewName());
		
	}
	
	@Test
	public void handleTableAction_edit() throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		TableCommand command = new TableCommand();
		command.setSelectedUsersIds(list);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "edit");
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/edit/1", redirectView.getUrl());
		
	}
	
	@Test
	public void handleTableAction_editWithError() throws Exception {
		
		TableCommand command = new TableCommand();
		
		when(bindingResult.hasErrors()).thenReturn(true);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "edit");
		
		assertEquals("tableJsp", modelAndView.getViewName());
		
	}
	
	@Test
	public void handleTableAction_delete() throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		TableCommand command = new TableCommand();
		command.setSelectedUsersIds(list);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "delete");
		RedirectView redirectView = (RedirectView)modelAndView.getView();
		
		assertEquals("/delete/1", redirectView.getUrl());
		
	}
	
	@Test
	public void handleTableAction_deleteWithError() throws Exception {
		
		TableCommand command = new TableCommand();
		
		when(bindingResult.hasErrors()).thenReturn(true);
		
		ModelAndView modelAndView = controller.handleTableAction(command, bindingResult, null, null, "delete");
		
		assertEquals("tableJsp", modelAndView.getViewName());
		
	}

}
