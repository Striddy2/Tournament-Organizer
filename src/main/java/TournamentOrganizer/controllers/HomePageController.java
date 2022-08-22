package TournamentOrganizer.controllers;

import TournamentOrganizer.models.data.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("tournaments", tournamentRepository.findAll());

        return "index";
    }

}
