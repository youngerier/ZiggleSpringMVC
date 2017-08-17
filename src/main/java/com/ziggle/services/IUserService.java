package com.ziggle.services;

import com.ziggle.modules.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();

    public void saveUser(User u);

    public void delete(long id);
}
