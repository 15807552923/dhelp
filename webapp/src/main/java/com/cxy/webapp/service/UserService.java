package com.cxy.webapp.service;

import com.cxy.webapp.dao.UserRepository;
import com.cxy.webapp.entity.User;
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
