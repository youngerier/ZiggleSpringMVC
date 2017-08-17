package com.ziggle.services;

import com.ziggle.dao.IUserJpaRepository;
import com.ziggle.modules.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
