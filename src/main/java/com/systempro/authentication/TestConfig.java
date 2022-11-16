package com.systempro.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.systempro.authentication.services.DBServer;

@Configuration
@Profile("test")
public class TestConfig {


	private final DBServer dbServer;

	public TestConfig(DBServer dbServer) {
		this.dbServer = dbServer;
	}

	@Bean
	public boolean iniDB() {
		dbServer.initializerDB();
		return true;
	}

}
