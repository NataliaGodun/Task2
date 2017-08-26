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

import by.htp.webpr.domain.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerProcessCommand {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showCustomerForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processCustomerForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		System.out.println("Last name: |" + theCustomer.getPassword() + "|");
		
		System.out.println("theBindingResult: " + theBindingResult);

		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "main-page";
		}
	}

	@RequestMapping("/showRegistrationForm")
	public String registration(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "registrationForm";
	}

	@RequestMapping("/registration")
	public String registrationForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

		System.out.println("Last name: |" + theCustomer.getPassword() + "|");
		
		System.out.println("theBindingResult: " + theBindingResult);

		if (theBindingResult.hasErrors()) {
			return "registrationForm";
		} else {
			return "main-page";
		}
	}
}
