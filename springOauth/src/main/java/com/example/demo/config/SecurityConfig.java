package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.service.CustomOAuth2UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomOAuth2UserService oAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/").permitAll()
		 .antMatchers("/login").permitAll()
		 .antMatchers("/user").hasRole("USER")
		 .anyRequest().authenticated()
		 .and()
		 .exceptionHandling().accessDeniedPage("/accessDenied")
		 .and()
		 .logout().logoutUrl("/logout")
		 .logoutSuccessUrl("/").permitAll()
		 .and()
		 .oauth2Login().loginPage("/login")
		 .userInfoEndpoint()
		 .userService(oAuth2UserService);
	}
	 
}
