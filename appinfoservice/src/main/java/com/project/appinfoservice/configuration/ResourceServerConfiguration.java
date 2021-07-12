package com.project.appinfoservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableResourceServer
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
     public void configure(HttpSecurity http) throws Exception {
              http.cors().and()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/openappinfo").permitAll()
                .antMatchers("/**").authenticated();



     }


//     https://stackoverflow.com/questions/45618529/spring-oauth2-access-any-resource-server-endpoint-without-authentication
}
