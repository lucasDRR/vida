package ar.com.lucas.vida.beneficiario;

import java.time.LocalDate;

public interface BeneficiarioDTO {
	
	public Long getId();
	public String getNombre();
	public String getApellido();
	public String getDni();
	public String getDireccion();
	public LocalDate getNacimiento();
	

}
