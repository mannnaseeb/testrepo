//package com.productcatalogue.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class ResourceServerConfig {
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.mvcMatcher("*")
//         .authorizeRequests()
//          .mvcMatchers("*").permitAll();
//          //.access("hasAuthority('SCOPE_articles.read')")
//          //.and()
//          //.oauth2ResourceServer()
//          //.jwt();
//        return http.build();
//    }
//}
