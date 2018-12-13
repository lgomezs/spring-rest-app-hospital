package pe.com.hospital.apphospital.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.hospital.apphospital.bean.Hospital;
import reactor.core.publisher.Mono;

@Repository()
public interface ReactivetRepositoryHospital extends ReactiveMongoRepository<Hospital, String>  {
	
	
}
