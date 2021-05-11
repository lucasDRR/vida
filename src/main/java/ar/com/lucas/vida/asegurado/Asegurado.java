package ar.com.lucas.vida.asegurado;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Poliza.class)
public class Asegurado{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String direccion;
	private Integer edad;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="asegurado")
	@JsonManagedReference
	private List<Poliza> polizas = new ArrayList<>();	
	
}
