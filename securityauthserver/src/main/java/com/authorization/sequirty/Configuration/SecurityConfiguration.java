package com.example.appbackendapi.Configuration;

import com.example.appbackendapi.Service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Qualifier("MyUserDetailService")


    @Autowired
    @Qualifier("myUserDetailService")
    private UserDetailsService userDetailsService;

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        return new MyUserDetailService();
//    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            User.withDefaultPasswordEncoder()
//                .username("enduser")
//                .password("password")
//                .roles("USER")
//                .build());
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        auth.authenticationProvider(provider);
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider());
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.oauth2Login();
//        super.configure(http);
//    }

    //    @override
//    protected void configure(httpsecurity http) throws exception {
//        http.authorizerequests()
//              .antmatchers("/users/getallusers").hasrole("user")
//             // .antmatchers("/**").hasrole("user");
//                .anyrequest().authenticated();
//    }


//    @override
//    protected void configure(httpsecurity http) throws exception {
//        http.csrf().disable()
//                .authorizerequests().antmatchers("/**").permitall();
////                .authorizerequests().antmatchers("/authenticate").permitall()
////                .anyrequest().authenticated();
//    }
//
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
//
    @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
}
