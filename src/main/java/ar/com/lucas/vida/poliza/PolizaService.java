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
	
	/*
	 * Busqueda por asegurado usando @Query 
	 * "select p from Poliza p where p.asegurado = ?1"

	 * */
	public List<Poliza> findPolizasPorAsegurado(Asegurado asegurado){
		return polizaRepo.findByAseguradoLike(asegurado);
	}
	
	public Optional<Poliza> findPoliza(Long id){
		return polizaRepo.findById(id);
	}
	
	public Poliza savePoliza(Poliza poliza) {
		return polizaRepo.save(poliza);
	}
	
	public void deletePoliza(Long id) {
		polizaRepo.deleteById(id);
	}
	
	public void deletePoliza(Poliza poliza) {
		polizaRepo.delete(poliza);
	}
}
