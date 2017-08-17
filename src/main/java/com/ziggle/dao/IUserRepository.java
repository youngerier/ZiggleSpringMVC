package com.ziggle.dao;

import com.ziggle.modules.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends Repository<User, Long> {

    List<User> findByNameAndAddAndAge(String name, int age);


    @Query(value = "from User u where u.name=:name")
    List<User> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#name} u where u.name=?1", nativeQuery = true)
    List<User> findByName2(String name);

    List<User> findByName(String name);

}
