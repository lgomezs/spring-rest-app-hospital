package pe.com.hospital.apphospital.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="Empleados")
public class Empleado {
	@Id
	private String id;
	private String empleado_cod;
	private String nombre;
	private String apellido;
	private String documento;
	private String oficio;
	private String fechaIngreso;
	private String salario;

}
