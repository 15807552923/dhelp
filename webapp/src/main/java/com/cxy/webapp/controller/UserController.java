package com.cxy.webapp.controller;
import com.cxy.webapp.entity.User;
import com.cxy.webapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author cxy
 * @projectName dhelp
 * @date 2018/04/19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public void getUser(String name){

        User user = userService.getUserInfo(name);
        System.out.println("hello,"+name);
    }
}
