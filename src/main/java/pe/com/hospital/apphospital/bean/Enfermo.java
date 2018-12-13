package pe.com.hospital.apphospital.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="Enfermos")
public class Enfermo {
	@Id
	private String id;
	private String inscripcion;
	private String documento;
	private String nombre;
	private String apellido;
	private String fechaIngreso;
	private String sexo;
	
}
