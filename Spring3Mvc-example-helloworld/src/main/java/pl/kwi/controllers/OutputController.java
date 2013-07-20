package pl.kwi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.InputCommand;
import pl.kwi.commands.OutputCommand;
import pl.kwi.services.NameService;

@Controller
@RequestMapping(value="/output")
public class OutputController{
	
	
	private NameService nameService;
	
	
	public OutputController(){
		nameService = new NameService();
	}
	
	
	@RequestMapping
	public ModelAndView displayPage(
			@ModelAttribute("command")InputCommand command,  
			HttpServletRequest request, 
			HttpServletResponse response){
		
		String name = nameService.load();
		command.setName(name);
		
		return new ModelAndView("outputJsp");
		
	}
	
	@RequestMapping(value="/handle-button-back", method=RequestMethod.POST)
	public ModelAndView handleButtonBack(
			@ModelAttribute("command")OutputCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
		
		return new ModelAndView(new RedirectView("/input", true, true, true));
		
	}	

}
