package com.babamerzoug.feo.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
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
public class RepositoryContext {

    private static final String MONGODB_HOST = "localhost";
    private final static String MONGODB_DATABASE_NAME = "foreigndb";
    ;

    @Bean
    MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new Mongo(MONGODB_HOST), MONGODB_DATABASE_NAME);
    }

    @Bean
    MongoTemplate mongoTemplate() throws UnknownHostException {
        MappingMongoConverter mongoConverter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoDbFactory(), mongoConverter);
    }
}
