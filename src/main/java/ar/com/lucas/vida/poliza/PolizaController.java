package ar.com.lucas.vida.poliza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.lucas.vida.asegurado.Asegurado;

@RestController
public class PolizaController {
	
	@Autowired
	private PolizaService polizaServ;
	
	@GetMapping("poliza")
	public List<Poliza> getAllPolizas(){
		return polizaServ.findAllPolizas();
	}
	
	@GetMapping("poliza/{id}")
	public Poliza getPolizaId(@PathVariable Long id) {
		return polizaServ.findPoliza(id).orElse(null);
	}
	
	@GetMapping("poliza/aseg")
	public List<Poliza> getPolizaByAsegurado(@RequestBody Asegurado asegurado){
		return polizaServ.findPolizasPorAsegurado(asegurado);
	}
	
	@PostMapping("poliza/add")
	public Poliza setPoliza(@RequestBody Poliza poliza) {
		return polizaServ.savePoliza(poliza);
	}
	
	@DeleteMapping("poliza/{id}/del")
	public void delPoliza(@PathVariable Long id) {
		polizaServ.deletePoliza(id);
	}
	
	@DeleteMapping("poliza/del")
	public void delPolizaEntity(@RequestBody Poliza poliza) {
		polizaServ.deletePoliza(poliza);
	}
	

}
