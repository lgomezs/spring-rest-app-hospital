package pe.com.hospital.apphospital.service;

import pe.com.config.security.appSecurity.repository.base.Command;
import pe.com.hospital.apphospital.bean.Medico;
import pe.com.hospital.apphospital.model.GetMedicoRequest;
import reactor.core.publisher.Mono;

public interface MedicoService  extends Command<Medico, GetMedicoRequest>{

	public Mono<Medico> update(GetMedicoRequest _getMedicoRequest);
}
