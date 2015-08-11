/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import java.util.ResourceBundle;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 *
 * @author hieptran
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.viettel.calendar.*"})
@EnableTransactionManagement
@Import({SecurityConfig.class, MvcConfig.class})

@PropertySource({"classpath:jdbc.properties", "classpath:jdbc.properties"})
public class AppConfig {

    static Log log = LogFactory.getLog(AppConfig.class.getName());

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean  sessionFactory() {
        LocalSessionFactoryBean  builder = new LocalSessionFactoryBean ();
        builder.setDataSource(dataSource());
        builder.setHibernateProperties(getHibernateProperties());
        builder.setPackagesToScan("com.viettel.calendar.beans");
        return builder;
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        prop.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        return prop;
    }

    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USERNAME = "jdbc.username";
    private static final String JDBC_PASSWORD = "jdbc.password";
    private static final String JDBC_DRIVER_CLASSNAME = "jdbc.driverClassName";
    private static final String JDBC_POOL_NAME = "jdbc.poolName";
    private static final String JDBC_TEST_QUERY = "jdbc.testQuery";
    private static final String JDBC_MAXIMUM_POOLSIZE = "jdbc.maximumPoolSize";
    private static final String JDBC_MINIMUM_IDLE = "jdbc.minimumIdle";
    private static final String JDBC_DATASOURCE_CLASSNAME = "jdbc.dataSourceClassName";
    private static final String JDBC_CACHE_PREP_STMTS = "cachePrepStmts";
    private static final String JDBC_PREP_STMT_CACHE_SIZE = "prepStmtCacheSize";
    private static final String JDBC_PREP_STMT_CACHE_SQL_LIMIT = "prepStmtCacheSqlLimit";
    private static final String JDBC_USESERVER_PREP_STMTS = "useServerPrepStmts";
    
    @Bean(name = "dataSource")
    public HikariDataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(env.getRequiredProperty(JDBC_DRIVER_CLASSNAME));
        hikariConfig.setJdbcUrl(env.getRequiredProperty(JDBC_URL)); 
        hikariConfig.setUsername(env.getRequiredProperty(JDBC_USERNAME));
        String encryptPassword = env.getRequiredProperty(JDBC_PASSWORD);
        String decryptedPassword;
        try {
            decryptedPassword = encryptPassword; //RSAEncrypt.decrypt(encryptPassword);//encryptPassword;//
            hikariConfig.setPassword(decryptedPassword);
        } catch (Exception ex) {
            log.error("AppConfig::dataSource::", ex);
        }
//        hikariConfig.setDataSourceClassName(env.getRequiredProperty(JDBC_DATASOURCE_CLASSNAME));
        hikariConfig.setMaximumPoolSize(Integer.valueOf( env.getRequiredProperty(JDBC_MAXIMUM_POOLSIZE)));
        hikariConfig.setMinimumIdle(Integer.valueOf( env.getRequiredProperty(JDBC_MINIMUM_IDLE)));
        hikariConfig.setConnectionTestQuery(env.getRequiredProperty(JDBC_TEST_QUERY));
        hikariConfig.setPoolName(env.getRequiredProperty(JDBC_POOL_NAME));
        hikariConfig.addDataSourceProperty(JDBC_CACHE_PREP_STMTS, env.getRequiredProperty(JDBC_CACHE_PREP_STMTS));
        hikariConfig.addDataSourceProperty(JDBC_PREP_STMT_CACHE_SIZE, env.getRequiredProperty(JDBC_PREP_STMT_CACHE_SIZE));
        hikariConfig.addDataSourceProperty(JDBC_PREP_STMT_CACHE_SQL_LIMIT, env.getRequiredProperty(JDBC_PREP_STMT_CACHE_SQL_LIMIT));
        hikariConfig.addDataSourceProperty(JDBC_USESERVER_PREP_STMTS, env.getRequiredProperty(JDBC_USESERVER_PREP_STMTS));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager txManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    private static final String CONFIG = "config";
    private static final String CONFIG_CHARCODE = "config.charCode";
    private static final String CONFIG_MAXSIZE = "config.maxSizeUpload";

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {

        ResourceBundle resource = ResourceBundle.getBundle(CONFIG);
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding(resource.getString(CONFIG_CHARCODE));
        resolver.setMaxUploadSize(Long.parseLong(resource.getString(CONFIG_MAXSIZE)));
        return resolver;

    }

    @Bean(name = "localeResolver")
    public org.springframework.web.servlet.i18n.CookieLocaleResolver createLocaleResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ROOT);
        localeResolver.setCookieName("workbenchLocaleCookie");
        localeResolver.setCookieMaxAge(157680000);
        return localeResolver;
    }

    @Bean(name = "messageSource")
    public org.springframework.context.support.ReloadableResourceBundleMessageSource createMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /*
     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
     * Remove this bean if you are not using @Value annotations for injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
