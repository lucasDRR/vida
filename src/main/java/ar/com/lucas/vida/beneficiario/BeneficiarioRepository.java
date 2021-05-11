package ar.com.lucas.vida.beneficiario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

	public Beneficiario findByNombre(String nombre);

}
