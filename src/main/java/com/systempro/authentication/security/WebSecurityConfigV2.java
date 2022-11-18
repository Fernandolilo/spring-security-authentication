package com.systempro.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigV2 {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.httpBasic().and()
		.authorizeHttpRequests()
				// delegando o role aos controlers com o @PreAuthorize("hasRole('ROLE_ADMIN')")
				/*
				 * .antMatchers(HttpMethod.POST, "/authentication/login/**").permitAll()
				 * .antMatchers(HttpMethod.GET, "/authentication/h2-console/**").permitAll()
				 */
				.anyRequest().authenticated()
				.and().csrf().disable();
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
