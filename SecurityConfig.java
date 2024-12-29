package com.sayan.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public AuthenticationSuccessHandler customSuccessHandler;
	
	@Bean
	public UserDetailsService getUserDetailsServices() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsServices());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		
		return daoAuthenticationProvider;
	}
	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.authenticationProvider(getDaoAuthProvider());
//	}
	
//	protected void configure(HttpSecurity http) throws Exception{
//		
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/user/**").hasRole("USER")
//		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").loginProcessingUrl("/login")
//		.defaultSuccessUrl("/user/").and().csrf().disable();
//	}
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//System.out.println("I am invoked!");
        
		http. authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/user/**").hasRole("USER")
		//.requestMatchers("/userindex").hasRole("USER")
		//.requestMatchers("/index").hasRole("ADMIN")
		.requestMatchers("/login").permitAll()
		.requestMatchers("/register").permitAll()
		.requestMatchers("/**").hasRole("ADMIN")
		.requestMatchers("/**").hasRole("USER")
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/login")
		.successHandler(customSuccessHandler)
		.and()
		.csrf().disable();
		
		
		http.authenticationProvider(getDaoAuthProvider());
		
        return http.build();
    }
	
	
}
