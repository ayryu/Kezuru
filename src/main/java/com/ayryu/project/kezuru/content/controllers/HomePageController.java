package com.ayryu.project.kezuru.content.controllers;

import com.ayryu.project.kezuru.content.services.EntryService;
import com.ayryu.project.kezuru.content.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomePageController {

//    @Autowired
    private EntryService entryService;

    @Autowired
    public HomePageController(EntryService theEntryService) {
        entryService = theEntryService;
    }

    @RequestMapping("/")
    public String index (Model model) {
        List<Entry> latest3Entries = entryService.findLatest3();
        model.addAttribute("latest3entries", latest3Entries);

        return "index";
    }
}
