package pe.com.hospital.apphospital.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="Hospitales")
public class Hospital{	
	@Id
	private String id;
	private String hopsitalCod;
	private String nombre;
	private String direccion;
	private String img;
	private String telefono;
	private String numCama;
	
	
}
