package ar.com.lucas.vida.cobertura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoberturaController {

	@Autowired
	private CoberturaService coService;

	// RECUPERAR

	@GetMapping("cobertura")
	public List<Cobertura> getCoberturas() {
		return coService.findAllCobertura();
	}

	@GetMapping("cobertura/{id}")
	public Cobertura getCobertura(@PathVariable Long id) {

		return coService.findCobertura(id).get();
	}

	@GetMapping("/cobertura/rama/{rama}")
	public List<Cobertura> getAllCoberturas(@PathVariable String rama) {
		return coService.findByRama(rama.toUpperCase());
	}

	@GetMapping("/cobertura/rama")
	public List<Cobertura> getCoberturasByRama(@RequestParam String rama) {
		return coService.findByRama(rama.toUpperCase());
	}

	// AGREGAR

	@PostMapping("cobertura/add")
	public Cobertura setCobertura(@RequestBody Cobertura cobertura) {
		return coService.saveCobertura(cobertura);
	}

	// MODIFICAR

	@PutMapping("cobertura/{id}")
	public Cobertura updateCobertura(@RequestBody Cobertura cobertura, @PathVariable Long id) {
		return coService.updateCobertura(cobertura, id).get();
	}

	// BORRAR

	// cambiar la URL
	@DeleteMapping("cobertura/{id}")
	public void delCobertura(@PathVariable Long id) {
		coService.deleteCobertura(id);
	}

	@DeleteMapping("cobertura/deleteCover")
	public void delCobertura(@RequestBody Cobertura cobertura) {
		coService.deleteByCobertura(cobertura);
	}

}
