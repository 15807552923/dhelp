package com.cxy.webapp.controller;
import com.cxy.webapp.entity.User;
import com.cxy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author cxy
 * @projectName dhelp
 * @date 2018/04/19
 */
@RestController
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

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
