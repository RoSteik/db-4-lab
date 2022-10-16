/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: lab4-db
 * Package: com.rostyslav.service.impl
 * Class: UserServiceImpl
 */

package com.rostyk.service.impl;

import com.rostyk.dao.UserDao;
import com.rostyk.domain.User;
import com.rostyk.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(String name) {
        return userDao.findById(name);
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int update(String name, User user) {
        return userDao.update(name, user);
    }

    @Override
    public int delete(String name) {
        return userDao.delete(name);
    }
}
