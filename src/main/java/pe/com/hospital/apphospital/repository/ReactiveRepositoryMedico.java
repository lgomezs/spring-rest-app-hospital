package pe.com.hospital.apphospital.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.hospital.apphospital.bean.Medico;

@Repository
public interface ReactiveRepositoryMedico extends ReactiveMongoRepository<Medico, String>{

	
}
