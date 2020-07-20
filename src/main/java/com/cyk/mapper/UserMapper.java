package com.cyk.mapper;

import com.cyk.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {



    //根据用户名查询用户
    User findByUsername(String username);

    //注册用户
    void save(User user);
}
