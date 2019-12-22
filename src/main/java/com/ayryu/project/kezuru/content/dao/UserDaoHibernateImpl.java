package com.ayryu.project.kezuru.content.dao;

import com.ayryu.project.kezuru.content.models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDAO {

    private EntityManager entityManager;

    private static final String USER_ALIAS = "from com.ayryu.project.kezuru.content.models.User as U";
    private static final String USER_ID_SELECTION = "SELECT U.id FROM " + USER_ALIAS;

    @Autowired
    public UserDaoHibernateImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery =
                currentSession.createQuery(USER_ALIAS, User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int theId) {
        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //the primary key is being passed in as an argument
        User theUser =
                currentSession.get(User.class, theId);

        return theUser;
    }

    @Override
    public void save(User theUser) {
        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //If the id(primary key) = 0, then it saves, otherwise it updates
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public void deleteById(int theId) {
        //Get the current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        javax.persistence.Query theQuery =
                currentSession.createQuery(
                        "delete " + USER_ALIAS + " where " + USER_ID_SELECTION + " =:userId");
        theQuery.setParameter("userId", theId);
        theQuery.executeUpdate();
    }
}
