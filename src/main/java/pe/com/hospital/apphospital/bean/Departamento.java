package pe.com.hospital.apphospital.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="Departamentos")
public class Departamento {
	@Id
	private String id;
	private String departamentoCod;
	private String nombre;
	
}
