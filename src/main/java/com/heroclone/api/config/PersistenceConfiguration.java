package com.heroclone.api.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.heroclone.api.dao.SampleDAO;
import com.heroclone.api.dao.impl.SampleDAOImpl;

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
    public BasicDataSource myDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUsername(dbUsername);
        bds.setPassword(dbPassword);
        bds.setUrl(dbURL);
        bds.setDriverClassName(dbDriver);
        return bds;
    }

    @Bean
    public LocalSessionFactoryBean mySessionFactory() {
        LocalSessionFactoryBean lfs = new LocalSessionFactoryBean();
        lfs.setPackagesToScan("com.heroclone.api.model");
        lfs.setDataSource(myDataSource());
        Properties hbProperties;
        hbProperties = new Properties();
        hbProperties.setProperty("hibernate.dialect", hbDialect);
        lfs.setHibernateProperties(hbProperties);
        return lfs;
    }
    
    @Bean
    public SampleDAO sampleDAO() {
        return new SampleDAOImpl();
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

}
