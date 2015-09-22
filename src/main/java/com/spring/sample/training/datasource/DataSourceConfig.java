package com.spring.sample.training.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataSourceConfig {

	@Bean(destroyMethod = "shutdown")
	@Profile("dev")
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.addScript("classpath:test-data.sql").build();
	}
	
	@Bean
	@Profile("prod")
	public DataSource jndiDataSource() {
		
		JndiObjectFactoryBean obj = new JndiObjectFactoryBean();
		obj.setJndiName("jdbc/myDS");
		obj.setResourceRef(true);
		obj.setProxyInterface(DataSource.class);
		
		return (DataSource) obj.getObject();
	}
}
