package com.info.masterslave.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


@Configuration
@ConfigurationProperties("spring.datasource-read")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRead",
        transactionManagerRef = "transactionManagerRead",
        basePackages = {"com.info.masterslave.repository.readRepository"}
)
public class DataSourceConfigRead extends HikariConfigRead {

    public final static String MODEL_PACKAGE = "com.info.masterslave.model";
    public final static String MAPPER_PACKAGE = "com.info.masterslave.mapper";

    public DataSourceConfigRead(HikariReadProperties hikariReadProperties) {
        super(hikariReadProperties);
    }

    @Bean
    public HikariDataSource dataSourceRead() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRead(
            final HikariDataSource dataSourceRead) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceRead);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_READ_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerRead(EntityManagerFactory entityManagerFactoryRead) {
        return new JpaTransactionManager(entityManagerFactoryRead);
    }

    // this is for mybatis mapper
    @Bean
    public SqlSessionFactory sessionFactory() {
        Environment env = new Environment("dev", new JdbcTransactionFactory(), dataSourceRead());
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration(env);
        config.addMappers("com.info.masterslave.mapper");
        return new SqlSessionFactoryBuilder().build(config);
    }
}