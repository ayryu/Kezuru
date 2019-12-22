package com.ayryu.project.kezuru.content.services;

import com.ayryu.project.kezuru.content.dao.EntryDAO;
import com.ayryu.project.kezuru.content.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryDAO entryDAO;

    @Autowired
    public EntryServiceImpl(EntryDAO theEntryDAO) {
        entryDAO = theEntryDAO;
    }

    @Override
    @Transactional
    public List<Entry> findAll() {
        return entryDAO.findAll();
    }

    @Override
    public List<Entry> findLatest3() {
        return entryDAO.findLatest3Entries();
    }

    @Override
    public Entry findTheEntryOfInterest() {
        return entryDAO.findEntryOfInterest();
    }

    @Override
    @Transactional
    public Entry findById(int theId) {
        return entryDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Entry theEntry) {
        entryDAO.save(theEntry);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        entryDAO.deleteById(theId);
    }
}
