package user.mgt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import user.mgt.service.CustomOAuth2UserService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomOAuth2UserService oAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/signup").permitAll()
		 .antMatchers("/signin").permitAll()
		 .antMatchers("/user").hasRole("USER")
		 .anyRequest().authenticated()
		 .and()
		 .exceptionHandling().accessDeniedPage("/accessDenied")
		 .and()
		 .logout().logoutUrl("/logout")
		 .logoutSuccessUrl("/").permitAll()
		 .and()
		 .oauth2Login().loginPage("/signin")
		 .userInfoEndpoint()
		 .userService(oAuth2UserService);
		 
		 
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
}
