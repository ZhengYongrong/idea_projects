package com.example.sbm.service;

import com.example.sbm.domain.User;

public interface UserService {
    public User getUserById(int userId);

    public boolean addUser(User record);

    public int deleteFromName(String name);

}