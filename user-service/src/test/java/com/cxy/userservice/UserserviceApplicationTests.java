package com.cxy.userservice;

import com.cxy.userservice.entity.User;
import com.cxy.userservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceApplicationTests {

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
		User user =userService.getUserInfo("cxy");
		System.out.println("test="+user.getName());
	}

}
