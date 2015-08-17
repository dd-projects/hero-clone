package com.heroclone.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableJpaRepositories("com.heroclone.api.repository")
public class PersistenceConfiguration {
    @Value("${db.url}")
    private String dbURL;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${hibernate.dialect}")
    private String hbDialect;
    
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUsername(dbUsername);
        bds.setPassword(dbPassword);
        bds.setUrl(dbURL);
        bds.setDriverClassName(dbDriver);
        return bds;
    }
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        
        Properties jpaProperties;
        jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", hbDialect);
        
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.heroclone.api.entity");
        factory.setDataSource(dataSource());
        
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();

        return factory.getObject();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

}
