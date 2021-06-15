package com.example.appbackendapi.Service;

import com.example.appbackendapi.Entity.User;
import com.example.appbackendapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         System.out.printf("************************************************************************");

         User user = new User(123,"bsingh91","12345","user");
         UserDetails userDetails = new MyUserDetail(user);
         return  userDetails;
//        Iterator<User> data = userRepository.findAll().iterator();
//        while (data.hasNext()){
//            User usr = data.next();
//            if(usr.getUsername().equals(username)){
//                System.out.printf("User name: %s\n Role: $s\n", usr.getUsername(), usr.getRole());
//                return new MyUserDetail(usr);
//            }
//        }
//        return null;
    }
}
