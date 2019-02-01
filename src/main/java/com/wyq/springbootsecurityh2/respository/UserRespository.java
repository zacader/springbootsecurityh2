package com.wyq.springbootsecurityh2.respository;

import com.wyq.springbootsecurityh2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description TODO
 * @Author Mike
 * @Date 2019/1/24
 * @Version 1.0
 */
public interface UserRespository extends JpaRepository<User, Long> {


    @Query("select new User(password,code) from User where name=?1")
    User getOneByName(String name);

}
