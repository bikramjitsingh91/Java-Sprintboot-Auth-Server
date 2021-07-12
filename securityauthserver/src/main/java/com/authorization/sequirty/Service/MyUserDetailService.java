package com.authorization.sequirty.Service;

import com.authorization.sequirty.Repository.UserRepository;
import com.authorization.sequirty.Entity.User;
import com.authorization.sequirty.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Qualifier("MyUserDetailServic")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr = userRepository.findUserByUserName(username);
        return new MyUserDetail(usr);
    }
}
