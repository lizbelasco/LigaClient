package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.MaximoGoleadorVelasco;
import com.soa.soap.LigaClient;

@SpringBootApplication
public class LigaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LigaClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(LigaClient client) {
        return args -> {
            MaximoGoleadorVelasco response = client.execute();
            System.err.println(response.getEquipo());
        };
    }
}
