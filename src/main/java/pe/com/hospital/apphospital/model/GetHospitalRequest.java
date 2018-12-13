package pe.com.hospital.apphospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetHospitalRequest {

	private String id;
	private String hospitaCod;
	private String nombre;
	private String img;
	private String telefono;
	private String numCama;
	private String direccion;
		
	public GetHospitalRequest() {}
	
}
