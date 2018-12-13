package pe.com.hospital.apphospital.service;

import pe.com.config.security.appSecurity.repository.base.Command;
import pe.com.hospital.apphospital.bean.Hospital;
import pe.com.hospital.apphospital.model.GetHospitalRequest;

import reactor.core.publisher.Mono;

public interface HospitalService extends Command<Hospital, GetHospitalRequest>{

	public Mono<Hospital> updateHospital(GetHospitalRequest getHospital);
}
