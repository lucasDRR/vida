package ar.com.lucas.vida.beneficiario;

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
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService benService;

	// RECUPERAR

	@GetMapping("beneficiario")
	public List<Beneficiario> getAllBeneficiarios() {
		return benService.findAllBeneficiarios();
	}

	@GetMapping("beneficiario/{id}")
	public Beneficiario getBeneficiario(@PathVariable Long id) {
		return benService.findBeneficiario(id).orElse(null);
	}

	// AGREGAR

	@PostMapping("beneficiario/add")
	public Beneficiario setBeneficiario(@RequestBody Beneficiario beneficiario) {
		return benService.saveBeneficiario(beneficiario);
	}

	@PostMapping("beneficiario/addAll")
	public List<Beneficiario> setBeneficiario(@RequestBody List<Beneficiario> beneficiarios) {
		return benService.saveBeneficiario(beneficiarios);
	}

	// MODIFICAR

	@PutMapping("beneficiario/{id}")
	public Beneficiario modifyBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {

		return benService.updateBeneficiario(id, beneficiario);
	}

	// BORRAR

	@DeleteMapping("beneficiario/{id}")
	public void delBeneficiario(@PathVariable Long id) {
		benService.deleteBeneficiario(id);
	}

	@DeleteMapping("beneficiario/del")
	public void delBeneficiario(@RequestBody Beneficiario beneficiario) {
		benService.deleteBeneficiario(beneficiario);
	}
}
