package ar.com.lucas.vida.asegurado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AseguradoController {

	@Autowired(required=true)
	private AseguradoService as;


	@GetMapping("asegurado")
	public List<Asegurado> getAllAsegurados(){
		return as.findAllAsegurados();
	}

	@GetMapping("asegurado/{id}")
	public Asegurado getAsegurado(@PathVariable Long id){
		return as.findAsegurado(id).orElseGet(Asegurado::new);
	}

	@PostMapping("asegurado/add")
	public Asegurado setAsegurado(@RequestBody Asegurado asegurado) {
		return as.saveAsegurado(asegurado);
	}

	@PutMapping("asegurado/{id}/update")
	public Asegurado updateAsegurado(@PathVariable Long id,
			@RequestBody Asegurado asegurado) {
		return as.updateUsuario(id, asegurado).orElseGet(Asegurado::new);
	}

	@DeleteMapping("asegurado/{id}/delete")
	public void deleteAsegurado(@PathVariable Long id) {
		as.deleteAsegurado(id);
	}
}
