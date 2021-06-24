package ar.com.lucas.vida.asegurado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AseguradoController {

	@Autowired
	private AseguradoService as;

	@GetMapping("asegurado")
	public List<Asegurado> getAllAsegurados() {
		return as.findAllAsegurados();
	}

	@GetMapping("asegurado/{id}")
	public Asegurado getAsegurado(@PathVariable Long id) {
		return as.findAsegurado(id).orElseGet(null);
	}

	/* Fake Login con dni */
	@GetMapping("asegurado/login")
	public AseguradoLoginDTO loginAsegurado(@RequestBody Integer dni) {
		return as.findAseguradoByDni(dni);
	}

	@PostMapping("asegurado/add")
	public Asegurado setAsegurado(@RequestBody Asegurado asegurado) {
		return as.saveAsegurado(asegurado);
	}

	@PutMapping("asegurado/{id}")
	public Asegurado updateAsegurado(@PathVariable Long id, @RequestBody Asegurado asegurado) {
		return as.updateUsuario(id, asegurado).orElseGet(Asegurado::new);
	}

	@DeleteMapping("asegurado/{id}")
	public void deleteAsegurado(@PathVariable Long id) {
		as.deleteAsegurado(id);
	}
}
