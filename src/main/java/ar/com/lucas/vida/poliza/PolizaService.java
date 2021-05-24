package ar.com.lucas.vida.poliza;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.lucas.vida.asegurado.Asegurado;

@Service
public class PolizaService {
	
	@Autowired
	private PolizaRepository polizaRepo;
	
	
	public List<Poliza> findAllPolizas(){
		return polizaRepo.findAll();
	}
	
	// busca una poliza por asegurado 
	
	public List<Poliza> findPolizasPorAsegurado(Asegurado asegurado){
		return polizaRepo.findByAseguradoLike(asegurado);
	}
	
	/* Busca por asegurado, retorna lista PolizaDTO */
	
	public List<PolizaDTO> findByAseguradoDTO(Asegurado asegurado){
		return polizaRepo.findByAsegurado(asegurado);
	}
	
	// Buscar una póliza por ID
	
	public Optional<Poliza> findPoliza(Long id){
		return polizaRepo.findById(id);
	}
	
	// Guardar una poliza nueva
	
	public Poliza savePoliza(Poliza poliza) {
		return polizaRepo.save(poliza);
	}
	
	/* Borrar polizas */
	
	public void deletePoliza(Long id) {
		polizaRepo.deleteById(id);
	}
	
	public void deletePoliza(Poliza poliza) {
		polizaRepo.delete(poliza);
	}
}
