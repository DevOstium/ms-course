package com.devsuperior.hrconfigserver;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	//private static Logger logger = org.slf4j.LoggerFactory.getLogger(HrConfigServerApplication.class);

	//@Value("${spring.cloud.config.server.git.username}")
	//private String userNameGitHub;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// logger.info("Variavel de Ambiente - USERNAME= " + userNameGitHub);
		//System.out.println(System.getenv("GITHUB_USER"));
	}

}
