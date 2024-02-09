package org.vladstasyshyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.vladstasyshyn.logging.repository")
public class AddressBookWebServerApp {
    public static void main(String[] args) {
        SpringApplication.run(AddressBookWebServerApp.class, args);
    }
}
