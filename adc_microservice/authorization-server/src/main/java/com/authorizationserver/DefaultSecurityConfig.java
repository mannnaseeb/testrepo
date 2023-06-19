package com.authorizationserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DefaultSecurityConfig {
	@Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.formLogin().and().authorizeRequests().anyRequest().authenticated().and().build();
		//return http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.withUsername("admin")
          .password("password").authorities("read").build();
        
        InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager();
        uds.createUser(user);
        return uds;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder( ) {
    	return NoOpPasswordEncoder.getInstance();
    }
}