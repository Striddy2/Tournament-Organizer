package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Login;
import TournamentOrganizer.models.data.LoginPageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class LoginPageController {

LoginPageRepository loginPageRepository;


    @GetMapping("login")
    public String displayLoginPage() {
        return "login";
    }


    @PostMapping("login")
    public String processLogin(@ModelAttribute @Valid Login newLogin, Errors errors, Model model, @RequestParam String userLogin, @RequestParam String userPassword){


        Login login = new Login(userLogin, userPassword);

        loginPageRepository.save(login);

        return "login"; //returns main when connected
    }
}

/*                                            Questions left to answer/Things left to do

1. Do we have to make functionality for if a user has logged in already (feels more advanced than I can do rn)or if a user has lost their password (again, maybe post MVP)?

2. How will you let the computer know to change the sign-in screen to main page?

 */