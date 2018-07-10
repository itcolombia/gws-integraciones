package com.gws.integraciones.maestros.configuracion;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = JpaConfiguration.PACKAGES_TO_SCAN_FOR_REPOSITORIES)
public class JpaConfiguration extends HikariConfig {

//	static final String PACKAGES_TO_SCAN_FOR_REPOSITORIES = "com.egakat.econnect.maestros.repository";

//	static final String[] PACKAGES_TO_SCAN_FOR_ENTITIES = { "com.egakat.econnect.maestros.domain",
	//		"com.egakat.core.data.jpa.converters" };

	static final String DATASOURCE_PROPERTIES_PREFIX = "spring.datasource";
	
	@Bean
	@ConfigurationProperties(prefix = DATASOURCE_PROPERTIES_PREFIX)
	public DataSource dataSource() {
		HikariDataSource result = DataSourceBuilder.create().type(HikariDataSource.class).build();
		return result;
	}
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
//			DataSource dataSource) {
//		val result = builder.dataSource(dataSource).packages(PACKAGES_TO_SCAN_FOR_ENTITIES).build();
//		return result;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		val result = new JpaTransactionManager(entityManagerFactory);
//		return result;
//	}
}