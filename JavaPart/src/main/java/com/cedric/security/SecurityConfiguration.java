package com.cedric.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

@Override
  protected void configure(HttpSecurity http) throws Exception {
	http
    .authorizeRequests()
      .antMatchers("/index.html", "/login", "/").permitAll()
      .antMatchers("/admin/**").hasRole("ADMIN")
      .anyRequest().authenticated();
  }

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication()
	    .withUser("user").password("password").roles("USER");
	  
	}
}
