package pe.com.hospital.apphospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pe.com.config.security.appSecurity.mongo.config.MultipleMongoConfig;
import pe.com.hospital.apphospital.mongo.config.MultipleMongoConfigHosiptal;


@Configuration
@EntityScan(basePackages = {
		"pe.com.config.security.appSecurity.bean",
		"pe.com.hospital.apphospital.bean"			
	})
@ComponentScan(basePackages = {
			"pe.com.config.security.appSecurity",		
			"pe.com.hospital"			
		})
@Import(value = {MultipleMongoConfig.class,MultipleMongoConfigHosiptal.class})
@SpringBootApplication()
public class AppHospitalApplication  {
		
	public static void main(String[] args) {
		SpringApplication.run(AppHospitalApplication.class, args);
	}	

}
