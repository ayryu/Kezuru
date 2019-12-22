package com.ayryu.project.kezuru.content.dao;

import com.ayryu.project.kezuru.content.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findById(int theId);

    public void save(User theUser);

    public void deleteById(int theId);
}
