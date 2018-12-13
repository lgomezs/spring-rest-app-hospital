package pe.com.hospital.apphospital.mongo.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import pe.com.core.mongo.mongodb.config.MongoDbProperties;

@PropertySource("classpath:config-default.properties")
@ConfigurationProperties(prefix="hospital")
public class MongoSecurityHospitalProperties extends MongoDbProperties{
			
	
}
