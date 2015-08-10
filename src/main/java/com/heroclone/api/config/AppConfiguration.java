package com.heroclone.api.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration  
@ComponentScan({ "com.heroclone.api.*"})
@Import({ MvcConfiguration.class}) //, SecurityConfig.class }) //, RepositoryConfiguration.class, SecurityConfiguration.class })
public class AppConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:application.properties"));
        return c;
    }
}
