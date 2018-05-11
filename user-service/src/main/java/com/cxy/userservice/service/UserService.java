package com.cxy.userservice.service;

import com.cxy.userservice.dao.UserRepository;
import com.cxy.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * describe:
 *
 * @author cxy
 * @projectName dhelp
 * @date 2018/04/19
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserInfo(String name){
        User user =userRepository.findUsersByName(name);
        return user;
    }


}
