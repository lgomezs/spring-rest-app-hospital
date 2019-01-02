package pe.com.hospital.apphospital.service.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.config.security.appSecurity.repository.base.AbstractCommand;
import pe.com.config.security.appSecurity.repository.base.ServiceExecutor;
import pe.com.hospital.apphospital.bean.Hospital;
import pe.com.hospital.apphospital.bean.Medico;
import pe.com.hospital.apphospital.exception.HospitalBaseException;
import pe.com.hospital.apphospital.model.GetHospitalRequest;
import pe.com.hospital.apphospital.model.GetMedicoRequest;
import pe.com.hospital.apphospital.repository.ReactiveRepositoryMedico;
import pe.com.hospital.apphospital.service.MedicoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MedicoServiceImpl extends AbstractCommand<Medico, GetMedicoRequest> implements MedicoService{

	@Autowired
	private ReactiveRepositoryMedico reactiveRepositoryMedico;
	
	@Override
	public Mono<Medico> doExecute(GetMedicoRequest request) {		
		Medico medico = createMedico(request);
		return reactiveRepositoryMedico.save(medico);
	}

	@Override
	public Flux<Medico> doExecuteList(GetMedicoRequest request) {		
		return reactiveRepositoryMedico.findAll();
	}

	@Override
	public Mono<Void> doDelete(GetMedicoRequest request) {
		return reactiveRepositoryMedico.delete(reactiveRepositoryMedico.findById(request.getId()).block());
	}


	@Override
	public Mono<Medico> update(GetMedicoRequest _getMedicoRequest) {
		Set<ConstraintViolation<GetMedicoRequest>> constraintViolations = validator.validate(_getMedicoRequest);
        if (constraintViolations.isEmpty() && _getMedicoRequest.getId()!=null) {
        	Medico medico = reactiveRepositoryMedico.findById(_getMedicoRequest.getId()).block();
        	Medico _medicoUpdate = createMedico(_getMedicoRequest);
        	_medicoUpdate.setId(medico.getId());        
        	return reactiveRepositoryMedico.save(_medicoUpdate);
        } else {
            return Mono.error(new HospitalBaseException(constraintViolations));
        }		
	}
	
	public Medico createMedico(GetMedicoRequest _gteMedicoRequest) {
		return Medico.builder()
		.nombre(_gteMedicoRequest.getNombre())
		.nroDoctor(_gteMedicoRequest.getNroDoctor())
		.especialidad(_gteMedicoRequest.getEspecialidad())
		.hospitalId(_gteMedicoRequest.getHospitalId())
		.build();
	}
}
