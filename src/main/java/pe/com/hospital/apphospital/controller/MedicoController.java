package pe.com.hospital.apphospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.config.security.appSecurity.repository.base.ServiceExecutor;
import pe.com.hospital.apphospital.bean.Medico;
import pe.com.hospital.apphospital.model.GetMedicoRequest;
import pe.com.hospital.apphospital.model.ResponseModel;
import pe.com.hospital.apphospital.service.MedicoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/api/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ServiceExecutor serviceExecutor;
	
	@RequestMapping(value = "listMedico" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ResponseModel<Medico>> listMedico() { 
		GetMedicoRequest _getMedicoRequest= GetMedicoRequest.builder().build();
		
		return serviceExecutor.executeList(MedicoService.class,_getMedicoRequest)
				.map(ResponseModel::ok)
				 .subscribeOn(Schedulers.elastic()); 
	}		
	
	
	@RequestMapping(value = "saveMedico" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Medico>> saveMedico(@RequestBody GetMedicoRequest request) { 
		GetMedicoRequest _getMedicoServiceRequest= GetMedicoRequest.builder()
				.nombre(request.getNombre())
				.nroDoctor(request.getNroDoctor())
				.especialidad(request.getEspecialidad())
				.hospitalId(request.getHospitalId())				
				.build();		
		
        return serviceExecutor.execute(MedicoService.class, _getMedicoServiceRequest)
        		.map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());              
    }
	
	
	@RequestMapping(value = "deleteMedico" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Void>> deleteMedico(@RequestBody GetMedicoRequest request) { 
		GetMedicoRequest _getMedicoRequest= GetMedicoRequest.builder()				
				.id(request.getId())			
				.build();		
		
        return serviceExecutor.delete(MedicoService.class, _getMedicoRequest)
        		.map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());              
    }
	
	
	@RequestMapping(value = "updateMedico" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Medico>> updateMedico(@RequestBody GetMedicoRequest request) { 		
		GetMedicoRequest _getMedicoRequest= GetMedicoRequest.builder()
					.id(request.getId())
					.nombre(request.getNombre())
					.nroDoctor(request.getNroDoctor())
					.especialidad(request.getEspecialidad())
					.hospitalId(request.getHospitalId())								
					.build();		
			
	        return medicoService.update(_getMedicoRequest)
	        		.map(ResponseModel::ok)
	                .subscribeOn(Schedulers.elastic());    	
    }
	
}
