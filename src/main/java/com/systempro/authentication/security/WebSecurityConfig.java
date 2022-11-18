package com.systempro.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsServiceImpl;

	public WebSecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests().anyRequest().authenticated().and().csrf().disable();

	}

	/*
	 * // criando autenticação em memoria
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth. inMemoryAuthentication() .withUser("fernando")
	 * .password(passwordEncoder().encode("1234")) .roles("USER"); }
	 */

	// criando autenticação em base de dados
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
