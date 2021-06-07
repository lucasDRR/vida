package ar.com.lucas.vida.beneficiario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository benRepo;

	// Recuperar
	public List<Beneficiario> findAllBeneficiarios() {
		return benRepo.findAll();
	}

	public Optional<Beneficiario> findBeneficiario(Long id) {
		return benRepo.findById(id);
	}

	public Optional<Beneficiario> findByName(String dni) {
		return benRepo.findOptionalByDni(dni);

	}

	// Guardar

	public Beneficiario saveBeneficiario(Beneficiario beneficiario) {
		return benRepo.save(beneficiario);
	}

	public List<Beneficiario> saveBeneficiario(List<Beneficiario> beneficiarios) {
		// Ingreso masivo de beneficiarios para una poliza,
		// se filtran los nulos.
		for (var it = beneficiarios.iterator(); it.hasNext();) {
			if (it.next() == null)
				it.remove();
		}
		return benRepo.saveAll(beneficiarios);
	}

	// Modificar sin implementar

	// Borrar

	public void deleteBeneficiario(Long id) {
		benRepo.deleteById(id);
	}

	public void deleteBeneficiario(Beneficiario b) {
		benRepo.delete(b);
	}

}
