package com.ziggle.dao;

import com.ziggle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<User, Long> {

}
