//package com.project.appinfoservice.configuration;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////          .authorizeRequests(authz -> authz
//////            .antMatchers(HttpMethod.GET, "/openappinfo").permitAll()
////            .antMatchers(HttpMethod.GET, "/appinfo").authenticated()
////            .anyRequest().authenticated()
////          );
//////          .oauth2ResourceServer(oauth2 -> oauth2.jwt());
////	}
//
//	 @Override
//     public void configure(HttpSecurity http) throws Exception {
//             http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/openappinfo").permitAll()
//                .antMatchers("/**").authenticated();
//
//
//     }
//}
