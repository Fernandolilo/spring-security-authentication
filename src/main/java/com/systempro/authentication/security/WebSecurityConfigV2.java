package com.systempro.authentication.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigV2 {

	@Autowired
	private Environment env;

	// liverado acesso ao banco de dados em ambiente de test
	private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// test caso o ambiente seja de test libera o acesso ao h2 if
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.httpBasic().and().authorizeHttpRequests()
		//validando a liberação dos endpoints dentro de PUBLIC_MATCHERS
		.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest()
				.authenticated().and().csrf().disable();
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}