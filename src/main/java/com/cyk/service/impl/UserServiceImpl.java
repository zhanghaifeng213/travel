package com.cyk.service.impl;


import com.cyk.domain.User;
import com.cyk.mapper.UserMapper;
import com.cyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        User userDB = userMapper.findByUsername(user.getUsername());
        if(userDB!=null){
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else{
            throw new RuntimeException("用户名输入错误!!!");
        }
    }

    @Override
    public void register(User user) {
        if (userMapper.findByUsername(user.getUsername()) == null) {
            userMapper.save(user);
        }else{
            throw new RuntimeException("用户名已经存在~~~~");
        }
    }
}
