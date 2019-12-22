package com.ayryu.project.kezuru.content.dao;

import com.ayryu.project.kezuru.content.models.Entry;

import java.util.List;

public interface EntryDAO {

    public List<Entry> findAll();

    List<Entry> findLatest3Entries();

    Entry findEntryOfInterest();

    public Entry findById(int theId);

    public void save(Entry theEntry);

    public void deleteById(int theId);
}
