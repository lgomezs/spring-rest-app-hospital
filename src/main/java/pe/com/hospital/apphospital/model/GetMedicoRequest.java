package pe.com.hospital.apphospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetMedicoRequest {

	private String id;
	private String nroDoctor;
	private String nombre;	
	private String especialidad;
	private String hospitalId;
	
	public GetMedicoRequest() {}
	
}
