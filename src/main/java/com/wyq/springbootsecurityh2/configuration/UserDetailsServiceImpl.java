package com.wyq.springbootsecurityh2.configuration;

import com.wyq.springbootsecurityh2.entity.User;
import com.wyq.springbootsecurityh2.respository.UserRespository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author Mike
 * @Date 2019/2/1
 * @Version 1.0
 */
@Service("MyUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserRespository userRespository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.getOneByName(username);
        if (user != null && user.getCode() != null) {
            return new org.springframework.security.core.userdetails.User
                    (username, passwordEncoder.encode(user.getPassword()), AuthorityUtils.NO_AUTHORITIES);
        }

        return null;
    }
}
