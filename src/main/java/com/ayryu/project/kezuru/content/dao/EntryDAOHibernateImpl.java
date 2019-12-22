package com.ayryu.project.kezuru.content.dao;

import com.ayryu.project.kezuru.content.models.Entry;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EntryDAOHibernateImpl implements EntryDAO {

    //Define field for EntityManager
    private EntityManager entityManager;

    private static final String ENTRY_ALIAS = "com.ayryu.project.kezuru.content.models.Entry as E";
    private static final String ENTRY_ID_SELECTION = "SELECT E.id from" + ENTRY_ALIAS;

    //set up constructor injection
    @Autowired
    public EntryDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Entry> findAll() {

        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Entry> theQuery =
                currentSession.createQuery("from " + ENTRY_ALIAS, Entry.class);

        //execute query and get result list
        List<Entry> entries = theQuery.getResultList();

        //return the results
        return entries;
    }

    @Override
    public List<Entry> findLatest3Entries() {
        return findAll().stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Entry findEntryOfInterest() {
        Entry entry = null;
        List<Entry> entryList = findAll().stream()
                                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                                .limit(1)
                                .collect(Collectors.toList());
        for(Entry entry1 : entryList) {
            entry = entry1;
        }
        return entry;
    }


    @Override
    public Entry findById(int theId) {

        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //the primary key is being passed in as an argument
        Entry theEntry =
                currentSession.get(Entry.class, theId);

        return theEntry;
    }

    @Override
    public void save(Entry theEntry) {
        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //If the id(primary key) = 0, then it saves, otherwise it updates
        currentSession.saveOrUpdate(theEntry);
    }

    @Override
    public void deleteById(int theId) {
        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        javax.persistence.Query theQuery =
                currentSession.createQuery(
                        "delete " + "from " + ENTRY_ALIAS + " where " + ENTRY_ID_SELECTION + " =:entryId");
                theQuery.setParameter("entryId", theId);
                theQuery.executeUpdate();
    }
}















