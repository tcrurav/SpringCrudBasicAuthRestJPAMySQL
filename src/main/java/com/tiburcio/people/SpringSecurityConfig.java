package com.tiburcio.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tiburcio.people.entity.services.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/persons").permitAll()
			.antMatchers("/person/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		    .httpBasic();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{	
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
}	
