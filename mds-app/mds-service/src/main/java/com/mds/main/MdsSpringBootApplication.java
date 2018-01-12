package com.mds.main;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.jndi.JndiObjectFactoryBean;

@SpringBootApplication
@ComponentScan("com.mds.*")
@MapperScan("com.mds.mapper.productprofile.")
public class MdsSpringBootApplication {
	
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(MdsSpringBootApplication.class, args);
	}
	
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
		
		return new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
					Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}

			@Override
			protected void postProcessContext(Context context) {
				
				ContextResource resource = new ContextResource();
				resource.setName(env.getProperty("db.jndiName"));
				
				resource.setType(DataSource.class.getName());
				resource.setProperty("driverClassName", env.getProperty("db.driverClassName"));
				resource.setProperty("url", env.getProperty("db.url")); 
				resource.setProperty("password", env.getProperty("db.password"));
                resource.setProperty("username", env.getProperty("db.username"));
				
				context.getNamingResources().addResource(resource);
			}
		};
	}

	@Bean(destroyMethod="")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:comp/env/jdbc/local_OracleDB"); 
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		bean.afterPropertiesSet();
		return (DataSource)bean.getObject();
	}
	
}
