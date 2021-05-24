package ar.com.lucas.vida.poliza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.lucas.vida.asegurado.Asegurado;

public interface PolizaRepository extends JpaRepository<Poliza, Long> {

	List<Poliza> findByAseguradoLike(Asegurado asegurado);
	
	List<PolizaDTO> findByAsegurado(Asegurado asegurado);
}
