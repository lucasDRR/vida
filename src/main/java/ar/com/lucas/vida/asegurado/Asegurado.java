package ar.com.lucas.vida.asegurado;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ar.com.lucas.vida.poliza.Poliza;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="idx", scope = Poliza.class)
public class Asegurado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String nombre;
	
	@Column(name="ADDRESS")
	private String direccion;
	
	@Column(name="DNI", nullable=false)
	private Integer dni;
	
	@Column(name="GENDER", nullable=false)
	private String genero;
	
	@Column(name="AGE")
	private Integer edad;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="asegurado")
	@JsonManagedReference
	private List<Poliza> polizas = new ArrayList<>();	
	
}
