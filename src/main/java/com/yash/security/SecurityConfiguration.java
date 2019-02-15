package com.yash.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM = "MY_TEST_REALM";

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("abc123").roles("USER1");
		auth.inMemoryAuthentication().withUser("user2").password("abc123").roles("USER2");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/auser").hasRole("USER1").antMatchers("/auser/**").authenticated()
				.antMatchers("/user").hasRole("USER").antMatchers("/user/**").authenticated().and().httpBasic()
				.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());

		/*
		 * http.csrf().disable() .authorizeRequests()
		 * .antMatchers("/auser/**").hasRole("ADMIN")
		 * .and().httpBasic().realmName(REALM).authenticationEntryPoint(
		 * getBasicAuthEntryPoint());
		 */

	}

	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
