package pe.com.hospital.apphospital.service.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.config.security.appSecurity.repository.base.AbstractCommand;
import pe.com.hospital.apphospital.bean.Hospital;
import pe.com.hospital.apphospital.exception.HospitalBaseException;
import pe.com.hospital.apphospital.model.GetHospitalRequest;
import pe.com.hospital.apphospital.repository.ReactivetRepositoryHospital;

import pe.com.hospital.apphospital.service.HospitalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HospitalServiceImpl extends AbstractCommand<Hospital, GetHospitalRequest> implements HospitalService{

	@Autowired
	private ReactivetRepositoryHospital reactivetRepositorypHospital;
	
	@Override
	public Mono<Hospital> doExecute(GetHospitalRequest request) {	
		Hospital _hospital = createHospital(request);		
		_hospital.setHopsitalCod(String.valueOf(reactivetRepositorypHospital.count().block()+1));	
		return reactivetRepositorypHospital.save(_hospital);		
//		return Mono.zip(			
//					objects -> addOrUpdateHospital((objects[0]!=null)?((Hospital) objects[0]):null,request),	              
//	                reactivetRepositorypHospital.findById(request.getId())				                            
//	     ).flatMap(hospital -> reactivetRepositorypHospital.save(hospital));
	}
	
	@Override
	public Mono<Hospital> updateHospital(GetHospitalRequest getHospital) {
		Set<ConstraintViolation<GetHospitalRequest>> constraintViolations = validator.validate(getHospital);
        if (constraintViolations.isEmpty() && getHospital.getId()!=null) {
        	Hospital _hospital = reactivetRepositorypHospital.findById(getHospital.getId()).block();
        	Hospital _hospitalUpdate = createHospital(getHospital);
        	_hospitalUpdate.setId(_hospital.getId());
        	_hospitalUpdate.setHopsitalCod(_hospital.getHopsitalCod());
        	return reactivetRepositorypHospital.save(_hospitalUpdate);
        } else {
            return Mono.error(new HospitalBaseException(constraintViolations));
        }
	}		
			
	@Override
	public Flux<Hospital> doExecuteList(GetHospitalRequest request) {		
		return reactivetRepositorypHospital.findAll();
	}
	
	@Override
	public Mono<Void> doDelete(GetHospitalRequest request) {		
		return reactivetRepositorypHospital.delete(reactivetRepositorypHospital.findById(request.getId()).block());		
	}
	
	public Hospital createHospital(GetHospitalRequest request) {
		return Hospital.builder().
			nombre(request.getNombre()).			
			direccion(request.getDireccion()).
			telefono(request.getTelefono()).
			numCama(request.getNumCama()).			
			img(request.getImg())			
			.build();
	}
}
