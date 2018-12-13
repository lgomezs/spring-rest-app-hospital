package pe.com.hospital.apphospital.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="Sala")
public class Sala {
	@Id
	private String id;
	private String cod_sala;
	private String hospitalCod;
	private String nombre;
	private String num_cama;
	
	
}
