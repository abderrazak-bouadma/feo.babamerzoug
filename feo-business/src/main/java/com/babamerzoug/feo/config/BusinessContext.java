package com.babamerzoug.feo.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/30/13
 * Time: 3:03 PM
 */

@Configuration
@EnableMongoRepositories(basePackages = {"com.babamerzoug.feo.repository"})
@ComponentScan(basePackages = {"com.babamerzoug.feo.business"})
public class BusinessContext {

    @Bean
    Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    MongoTemplate mongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "foreigndb");
    }

}
