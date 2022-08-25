package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Registration;
import TournamentOrganizer.models.data.RegistrationPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
public class RegistrationPageController {

    @Autowired
    private RegistrationPageRepository registrationPageRepository;


    //display signup page
    @GetMapping("registrationPage")
    public String displaySignupPage(Model model) {
        model.addAttribute("title", "create registration"); //title?
        model.addAttribute(new Registration());//this was to pull over object data--didn't work :-(
                return "registrationPage";
    }


    //process user registrations
    @PostMapping("registrationPage")
    public String processUserRegistration(@ModelAttribute @Valid Registration newRegister,    //newRegister is never called...ummm??
                                          Errors errors, Model model, @RequestParam String username,
                                                                      @RequestParam String emailAddress,
                                                                      @RequestParam String password,
                                                                      @RequestParam String verifyPassword) {

        Registration register = new Registration(username,emailAddress,password,verifyPassword); //can newRegister go here?

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create title");
            model.addAttribute("emailError", "Please check email address");

            if(username.length() <= 2){
                model.addAttribute("title", "Create title");
                model.addAttribute("lengthError", "username must be at least 3 characters in length");
            }

            if(!register.getPassword().equals(register.getVerifyPassword())) {
                model.addAttribute("title", "Create title");
                model.addAttribute("PasswordMatchError", "Passwords do not match");
                return "registrationPage";
            }
    }
        registrationPageRepository.save(register);
        return "login";
    }
}



/*                                            Questions left to answer/Things left to do

1. How do I call the table name from the database to check if a user has already signed up?

2. you need to do redirecting to the main page for processUserRegistration

3. How do you set login status to false for the site, denying access to create, edit, and delete tournaments?  Is this too hight for us as our first MVP project?

4. After someone has signed up, I want the user re-routed to the main page with a login status as true, giving them access to create, edit, delete.
*/







