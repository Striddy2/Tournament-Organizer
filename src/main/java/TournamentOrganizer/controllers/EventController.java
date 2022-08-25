package TournamentOrganizer.controllers;

import TournamentOrganizer.models.Event;
import TournamentOrganizer.models.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String displayEvents(
            Model model
    ) {
        String sendToTemplateViewEventsIndex = "events/index";

        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return sendToTemplateViewEventsIndex;
    }

    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model) {
        String sendToTemplateViewEventsCreate =  "events/create";

        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return sendToTemplateViewEventsCreate;
    }

    @PostMapping(value = "create")
    public String processCreateEventForm(
            @ModelAttribute @Valid Event newEvent,
            Errors errors,
            Model model
    ) {
        String sendToTemplateViewEventsCreate = "events/create";
        String redirect = "redirect:";

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return sendToTemplateViewEventsCreate;
        }
        eventRepository.save(newEvent);
        return redirect;
    }

    @GetMapping(value = "delete")
    public String displayDeleteEventForm(Model model) {
        String sendToTemplateViewEventsDelete = "events/delete";

        model.addAttribute(
                "title",
                "Delete Event"
        );

        model.addAttribute(
                "events",
                eventRepository.findAll()
        );

        return sendToTemplateViewEventsDelete;
    }

    @PostMapping(value = "delete")
    public String processDeleteEventForm(
            @RequestParam(required = false) int[] eventIds
    ) {
        String redirect = "redirect:";

        if(eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return redirect;
    }

    @GetMapping(value = "detail")
    public String displayEventDetails (
            @RequestParam Integer eventId,
            Model model
    ) {
        String sendToTemplateViewEventsDetail = "events/detail";
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
        }
        return sendToTemplateViewEventsDetail;
    }

    @GetMapping(value = "edit/{eventId}")
    public String displayEditEventForm(
            Model model,
            @PathVariable int eventId
    ) {
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        model.addAttribute("event", eventToBeEdit);
        String title = "Edit Event: " + eventToBeEdit.getName() + " (id=" + eventToBeEdit.getId() + ")";
        model.addAttribute("title", title);
        String sendToTemplateViewEventsEdit =  "events/edit";
        return sendToTemplateViewEventsEdit;
    }

    @PostMapping(value = "edit")
    public String processEditEventForm(
            int eventId,
            String name,
            String description,
            String location,
            String competitiveLevel,
            String date,
            String summary,
            String entryFee
    ) {
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        eventToBeEdit.setName(name);
        eventToBeEdit.setDescription(description);
        eventToBeEdit.setLocation(location);
        eventToBeEdit.setCompetitiveLevel(competitiveLevel);
        eventToBeEdit.setDate(date);
        eventToBeEdit.setSummary(summary);
        eventToBeEdit.setEntryFee(entryFee);
        eventRepository.save(eventToBeEdit);
        String redirect = "redirect:";
        return redirect;
    }
}
