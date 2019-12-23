package com.ayryu.project.kezuru.content.controllers;

import com.ayryu.project.kezuru.content.models.Entry;
import com.ayryu.project.kezuru.content.services.EntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/entries")
public class EntryController {

//    @Autowired
    private EntryService entryService;

    public EntryController(EntryService theEntryService) {
        entryService = theEntryService;
    }

    @GetMapping("/showNewEntryForm")
    public String showNewEntryForm(Model model) {

        Entry newEntry = new Entry();

        model.addAttribute("newEntry", newEntry);

        return "new-entry-form";
    }

    //new-entry-form will pass the model from the showNewEntryForm method to this method
    @PostMapping("/saveNewEntry")
    public String saveEntry(@ModelAttribute("newEntry") Entry newEntry) {

        entryService.save(newEntry);

        return "redirect:/";
    }

    @GetMapping("/listOfEntries")
    public String listEntries(Model model) {

        List<Entry> listOfEntries = entryService.findAll();

        model.addAttribute("entries", listOfEntries);

        return "";
    }
}
