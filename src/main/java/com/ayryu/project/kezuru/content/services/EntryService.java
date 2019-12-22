package com.ayryu.project.kezuru.content.services;

import com.ayryu.project.kezuru.content.models.Entry;

import java.util.List;

public interface EntryService {

    public List<Entry> findAll();

    public List<Entry> findLatest3();

    public Entry findTheEntryOfInterest();

    public Entry findById(int theId);

    public void save(Entry theEntry);

    public void deleteById(int theId);
}
