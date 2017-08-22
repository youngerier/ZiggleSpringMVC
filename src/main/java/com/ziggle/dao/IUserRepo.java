package com.ziggle.dao;


import com.ziggle.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IUserRepo extends Repository<User, Long> {

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAll();

    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
    List<User> findByName(String name);
}
