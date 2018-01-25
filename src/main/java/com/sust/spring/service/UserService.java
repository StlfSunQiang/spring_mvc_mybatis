package com.sust.spring.service;

import com.sust.spring.domain.User;
import com.sust.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers(){
        return userMapper.findAllUsers();
    }

    public User findById(Long id){
        return userMapper.findById(id);
    }

    public boolean createNewUser(User user){
        int rowCount = userMapper.createNewUser(user);
        return rowCount == 1 ? true : false;
    }

    public boolean updateUser(User user){
        int rowCount = userMapper.updateUser(user);
        return rowCount == 1 ? true : false;
    }

    public User findWithFileById(Long id){
        return userMapper.findWithFileById(id);
    }

    //保存图片信息
    public void addProfileImage(Long userId, String fileName){
        //调用mapper

    }
}
