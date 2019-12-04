package br.com.bandtec.bora.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.bandtec.bora.core.model" })
@EnableJpaRepositories(basePackages = { "br.com.bandtec.bora.core.repository" })
@EnableMongoRepositories("br.com.bandtec.bora.core.repository")
@ComponentScan(basePackages = { "br.com.bandtec.bora" })
@EnableEurekaClient
@EnableCaching
public class BoraApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoraApplication.class, args);
    }

}
