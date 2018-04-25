package com.cxy.userservice.dao;

import com.cxy.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * describe:
 *
 * @author cxy
 * @projectName dhelp
 * @date 2018/04/19
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findUsersByName(String name);
}
