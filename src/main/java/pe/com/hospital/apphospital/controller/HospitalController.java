package pe.com.hospital.apphospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.config.security.appSecurity.repository.base.ServiceExecutor;
import pe.com.hospital.apphospital.bean.Hospital;
import pe.com.hospital.apphospital.model.GetHospitalRequest;
import pe.com.hospital.apphospital.model.ResponseModel;

import pe.com.hospital.apphospital.service.HospitalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

	@Autowired
	private ServiceExecutor serviceExecutor;
	@Autowired
	private HospitalService _hospitalService;

	
	@RequestMapping(value = "saveHospital" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Hospital>> saveHospital(@RequestBody GetHospitalRequest hospitalRequest) { 
		GetHospitalRequest _gGetHospitalRequest= GetHospitalRequest.builder()
				.nombre(hospitalRequest.getNombre())
				.direccion(hospitalRequest.getDireccion())
				.numCama(hospitalRequest.getNumCama())
				.telefono(hospitalRequest.getTelefono())
				.img(hospitalRequest.getImg())
				.build();		
		
        return serviceExecutor.execute(HospitalService.class, _gGetHospitalRequest)
        		.map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());              
    }
	
	@RequestMapping(value = "updateHospital" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Hospital>> updateHospital(@RequestBody GetHospitalRequest hospitalRequest) { 		
			GetHospitalRequest _gGetHospitalRequest= GetHospitalRequest.builder()
					.id(hospitalRequest.getId())
					.nombre(hospitalRequest.getNombre())
					.direccion(hospitalRequest.getDireccion())
					.numCama(hospitalRequest.getNumCama())
					.telefono(hospitalRequest.getTelefono())
					.img(hospitalRequest.getImg())
					.hospitaCod(hospitalRequest.getHospitaCod())
					.build();		
			
	        return _hospitalService.updateHospital(_gGetHospitalRequest)
	        		.map(ResponseModel::ok)
	                .subscribeOn(Schedulers.elastic());    	
    }
	
	
	@RequestMapping(value = "listHospital" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ResponseModel<Hospital>> listHospital() { 
		GetHospitalRequest _gGetHospitalRequest= GetHospitalRequest.builder().build();
        return serviceExecutor.executeList(HospitalService.class, _gGetHospitalRequest)
        		.map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());              
    }
	
	
	@RequestMapping(value = "deleteHospital" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseModel<Void>> deleteHospital(@RequestBody GetHospitalRequest hospitalRequest) { 
		GetHospitalRequest _gGetHospitalRequest= GetHospitalRequest.builder()				
				.id(hospitalRequest.getId())			
				.build();		
		
        return serviceExecutor.delete(HospitalService.class, _gGetHospitalRequest)
        		.map(ResponseModel::ok)
                .subscribeOn(Schedulers.elastic());              
    }
	 
}
