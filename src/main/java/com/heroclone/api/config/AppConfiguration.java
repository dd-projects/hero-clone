package com.heroclone.api.config;

import java.io.IOException;

import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jndi.JndiTemplate;

@Configuration
@ComponentScan({ "com.heroclone.api.*" })
@Import({ MvcConfiguration.class })
public class AppConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer()
            throws IOException {

        JndiTemplate jd = new JndiTemplate();
        String home = null;
        try {
            home = (String) jd.lookup("java:comp/env/appsHome");
        } catch (NamingException e) {
            home = "/opt";
        }

        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setLocations(new PathMatchingResourcePatternResolver()
                .getResources("file:" + home
                        + "/heroclone/application.properties"));
        return c;
    }
}
