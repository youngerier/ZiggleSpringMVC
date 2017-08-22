package com.ziggle.services.impl;

import com.ziggle.dao.IUserJpaRepository;
import com.ziggle.entity.User;
import com.ziggle.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserJpaRepository IUserJpaRepository;


    public List<User> findAll() {
        return IUserJpaRepository.findAll();
    }

    public void saveUser(User u) {
        IUserJpaRepository.save(u);
    }

    public void delete(long id) {
        IUserJpaRepository.delete(id);
    }
}
