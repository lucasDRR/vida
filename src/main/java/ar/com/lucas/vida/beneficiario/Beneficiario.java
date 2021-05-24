package ar.com.lucas.vida.beneficiario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Beneficiario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false, length=48)
	private String nombre;
	
	@Column(name = "APELLIDO", nullable = false, length=48)
	private String apellido;
	
	@Column(name = "DNI", nullable = false, length=16)
	private String dni;
	
	@Column(name = "DIRECCION", nullable = true, length=120)
	private String direccion;
	
	@Column(name = "NACIDO", nullable = true)
	private LocalDate nacimiento;

}
