package com.heroclone.api.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.heroclone.api.dao.SampleDAO;
import com.heroclone.api.dao.impl.SampleDAOImpl;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
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
	
	
	
    @Override
    public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer )
    {
        configurer.enable();
    }
 
    @Bean
	public SampleDAO sampleDAO() {
		return new SampleDAOImpl();
	}

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
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
  
       return txManager;
    }
    
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
    
}
