package pe.com.hospital.apphospital.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.com.hospital.apphospital.bean.Hospital.HospitalBuilder;

@Data
@Builder
@Document(collection="Medicos")
public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nroDoctor;
	private String nombre;	
	private String especialidad;
	private String hospitalId;
	
}
