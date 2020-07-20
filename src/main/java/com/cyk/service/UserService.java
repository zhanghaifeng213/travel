package com.cyk.service;


import com.cyk.domain.User;

public interface UserService {



    User login(User user);

    void register(User user);
}
