package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("io.playda.controller")
@EnableJpaRepositories(basePackages="io.playdata.dao")
@EntityScan("io.playdata.model.domain")
public class Step08MyArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step08MyArtApplication.class, args);
	}

}