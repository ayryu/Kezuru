package com.ayryu.project.kezuru.content.rest;

import com.ayryu.project.kezuru.content.models.Entry;
import com.ayryu.project.kezuru.content.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntryRestController {

    private EntryService entryService;
    private Entry entryOfInterest;

    @Autowired
    public EntryRestController(EntryService theEntryService) {
        entryService = theEntryService;
    }

    //expose "/entries" endpoint which returns list of entries
    @GetMapping("/entries")
    public List<Entry> findAll() {
        return entryService.findAll();
    }

    @GetMapping("/entriesthree")
    public List<Entry> findFirst3Entries() {
        return entryService.findLatest3();
    }

    @GetMapping("/newest-entry")
    public Entry getEntryOfInterest() {
        return entryService.findTheEntryOfInterest();
    }

    @GetMapping("/entries/{entryId}")
    public Entry getEntry(@PathVariable int entryId) {
        Entry theEntry = entryService.findById(entryId);

        if(theEntry == null) {
            throw new RuntimeException("Entry id was not found - " + entryId);
        }
        return theEntry;
    }

    @PostMapping("/entries")
    public Entry addEntry(@RequestBody Entry theEntry) {
        theEntry.setId(0);

        entryService.save(theEntry);

        return theEntry;
    }

    @PutMapping("/entries")
    public Entry updateEntry(@RequestBody Entry theEntry) {
        entryService.save(theEntry);
        return theEntry;
    }

    @DeleteMapping("/entries/{entryId}")
    public String deleteEntry(@PathVariable int entryId) {

        Entry theEntry = entryService.findById(entryId);

        if(theEntry == null) {
            throw new RuntimeException("Entry ID not found: " + entryId);
        }

        entryService.deleteById(entryId);

        return "Deleted entry ID: " + entryId;
    }

//    @GetMapping("/successful-post")
//    public String showSuccessfulPost(@RequestBody Entry theEntry, Model model) {
//        addEntry(theEntry);
//        model.addAttribute("new-entry", theEntry);
//        return"successful-post";
//    }
}














































