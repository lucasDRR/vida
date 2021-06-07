package ar.com.lucas.vida.poliza;

import java.time.LocalDate;


public interface PolizaDTO {
	
	Long getId();
	Integer getSuma();
	String getPago();
	String getMedioPago();
	String getMoneda();
	LocalDate getInicioVigencia();
	Double getCuota();
	Cobertura getCobertura();
	
	public interface Cobertura{
		String getNombre();
	}

}
