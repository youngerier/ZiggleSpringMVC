package com.ziggle.dao;

import com.ziggle.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<User, Long> {

}
