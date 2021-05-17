package ar.com.lucas.vida.poliza;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ar.com.lucas.vida.asegurado.Asegurado;
import ar.com.lucas.vida.beneficiario.Beneficiario;
import ar.com.lucas.vida.cobertura.Cobertura;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
					property="@id", scope = Asegurado.class)
public class Poliza{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer sumaAsegurada;
	
	private String pago;

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="ASEG_ID")
	@JsonBackReference
	private Asegurado asegurado;
	
	
	@OneToOne(orphanRemoval=false)
	@JoinColumn(name= "FK_COVER")
	private Cobertura cobertura;
	
	//@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_BENEF")
	private Set<Beneficiario> beneficiarios;
	
		
}
