package com.ayryu.project.kezuru.content.controllers;

import com.ayryu.project.kezuru.content.services.EntryService;
import com.ayryu.project.kezuru.content.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NavigationBarController {

//    @Autowired
    private EntryService entryService;

    @Autowired
    public NavigationBarController(EntryService theEntryService) {
        entryService = theEntryService;
    }

    @GetMapping("/home")
    public String index (Model model) {
        List<Entry> latest3Entries = entryService.findLatest3();
        model.addAttribute("latest3entries", latest3Entries);

        return "index";
    }
}
