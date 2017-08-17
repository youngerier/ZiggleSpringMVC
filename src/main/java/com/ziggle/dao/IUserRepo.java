package com.ziggle.dao;


import com.ziggle.modules.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IUserRepo extends Repository<User, Long> {
    List<User> findByNameAndAge(String name, long age);

    @Query(value = "select * from user u where u.name=?1", nativeQuery = true)
    List<User> findByName(String name);


}
