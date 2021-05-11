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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ar.com.lucas.vida.asegurado.Asegurado;
import ar.com.lucas.vida.beneficiario.Beneficiario;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
					property="@id", scope = Asegurado.class)
public class Poliza{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cobertura;
	private Integer sumaAsegurada;
	private String pago;

	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="ASEG_ID")
	@JsonBackReference
	private Asegurado asegurado;
	/*
	@OneToOne(orphanRemoval=false)
	@JoinColumn(name= "FK_RAMO")
	private Ramo tipo; */
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="poliza", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Beneficiario> beneficiarios;
	
	
	
	
}
