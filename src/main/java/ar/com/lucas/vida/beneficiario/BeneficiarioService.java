package ar.com.lucas.vida.beneficiario;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public List<BeneficiarioDTO> findBeneficiarioDTO(Long id) {
		return benRepo.findByPolizaId(id);
	}

	// GUARDAR

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

	// Modificar

	@Transactional
	public Beneficiario updateBeneficiario(Long id, Beneficiario b) {

		Optional<Beneficiario> temp = benRepo.findById(id);

		temp.ifPresent(p -> {

			p.setApellido(b.getApellido());
			p.setNombre(b.getNombre());
			p.setDni(b.getDni());
			p.setDireccion(b.getDireccion());
			p.setNacimiento(b.getNacimiento());

			benRepo.save(temp.get());
		});

		return temp.get();

	}

	// Borrar

	public void deleteBeneficiario(Long id) {
		benRepo.deleteById(id);
	}

}
