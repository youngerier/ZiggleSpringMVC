package com.ziggle.services;

import com.ziggle.dao.IUserJpaRepository;
import com.ziggle.dao.IUserRepository;
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

    @Autowired
    private IUserRepository userRepository;

    public List<User> findAll() {
        return IUserJpaRepository.findAll();
    }


    @Cacheable
    public User findOne(long id) {
        return IUserJpaRepository.findOne(id);
    }

    public void saveUser(User u) {
        IUserJpaRepository.save(u);
    }

    public void delete(long id) {
        IUserJpaRepository.delete(id);
    }

    public List<User> findByName(String name) {
        List<User> userlist1 = userRepository.findByName(name);
        return userlist1;
    }
}
