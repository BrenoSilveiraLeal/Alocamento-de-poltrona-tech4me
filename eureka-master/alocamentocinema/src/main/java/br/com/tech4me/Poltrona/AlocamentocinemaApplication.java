package br.com.tech4me.Poltrona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlocamentocinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlocamentocinemaApplication.class, args);
	}

}
