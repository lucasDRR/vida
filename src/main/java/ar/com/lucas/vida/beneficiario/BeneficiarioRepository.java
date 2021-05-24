package ar.com.lucas.vida.beneficiario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

	public Optional<Beneficiario> findOptionalByDni(String dni);

}
