package ar.com.lucas.vida.beneficiario;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.com.lucas.vida.poliza.Poliza;
import lombok.Data;

@Data
@Entity
public class Beneficiario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String direccion;

	//@ManyToOne(fetch = FetchType.LAZY)
	//private Poliza poliza;

}
