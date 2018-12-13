package pe.com.hospital.apphospital.mongo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import pe.com.core.mongo.mongodb.config.MongoDBConfig;
import pe.com.hospital.apphospital.mongo.config.properties.MongoSecurityHospitalProperties;


@Configuration
@EnableConfigurationProperties(MongoSecurityHospitalProperties.class)
@EnableReactiveMongoRepositories(
		basePackages = {
				"pe.com.hospital.apphospital.repository"
			},	
		reactiveMongoTemplateRef="hospitaltemplateReference"
		)
public class MultipleMongoConfigHosiptal extends MongoDBConfig {

	@Autowired
	private  MongoSecurityHospitalProperties mongoSecurityHospitalProperties;
	
	@PostConstruct
	public void init() {
		super.setProperties(mongoSecurityHospitalProperties);
	}	

	@Bean(name = "hospitaltemplateReference")
	public ReactiveMongoTemplate reactiveMongoTemplate() throws Exception {
		return super.reactiveMongoTemplate();
	}

	@Bean(name = "hospitaltemplateReferenceDbFactory")
	public ReactiveMongoDatabaseFactory mongoDbFactory() throws Exception {
		return super.mongoDbFactory();
	}
}
