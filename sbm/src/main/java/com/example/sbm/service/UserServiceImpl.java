package com.example.sbm.service;

import com.example.sbm.dao.UserDao;
import com.example.sbm.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record) {
        boolean result = false;
        try {
            System.out.println("1111111111111");
            userDao.insertSelective(record);
            System.out.println("2222222222222222");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteFromName(String name) {

        return userDao.deleteFromName(name);
    }


}