package ar.com.lucas.vida.poliza;

import java.time.LocalDate;


public interface PolizaDTO {
	
	Long getId();
	Integer getSumaAsegurada();
	String getPago();
	LocalDate getInicioVigencia();
	Double getCuota();
	Cobertura getCobertura();
	
	public interface Cobertura{
		String getNombre();
	}

}
