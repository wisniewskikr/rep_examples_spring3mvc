package pl.kwi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.InputCommand;
import pl.kwi.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController{
	
	
	private NameService nameService;
	
	
	public InputController(){
		nameService = new NameService();
	}
	
	
	@RequestMapping
	public ModelAndView displayPage(
			@ModelAttribute("command")InputCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
				
		return new ModelAndView("inputJsp");
		
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public ModelAndView handleButtonOk(
			@ModelAttribute("command")InputCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
		
		String name = command.getName();
		nameService.save(name);
		
		return new ModelAndView(new RedirectView("/output", true, true, true));
		
	}

}
