package by.htp.webpr.command;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.webpr.domain.User;

@Controller
@RequestMapping("/user")
public class UserProcessCommand {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showUserForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("user", new User());

		return "FirstUserForm";
	}

	@RequestMapping("/processUserForm")
	public String processForm(@Valid @ModelAttribute("user") User theCustomer, BindingResult theBindingResult) {

		System.out.println("Last name: |" + theCustomer.getPassword() + "|");
		
		System.out.println("theBindingResult: " + theBindingResult);

		if (theBindingResult.hasErrors()) {
			return "FirstUserForm";
		} else {
			return "main-page";
		}
	}

	@RequestMapping("/showRegistrationForm")
	public String registration(Model theModel) {

		theModel.addAttribute("user", new User());

		return "registrationForm";
	}

	@RequestMapping("/registration")
	public String registrationForm(@Valid @ModelAttribute("user") User theCustomer, BindingResult theBindingResult) {

		System.out.println("Last name: |" + theCustomer.getPassword() + "|");
		
		System.out.println("theBindingResult: " + theBindingResult);

		if (theBindingResult.hasErrors()) {
			return "registrationForm";
		} else {
			return "main-page";
		}
	}
}
