package ar.com.lucas.vida.poliza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.lucas.vida.asegurado.Asegurado;

public interface PolizaRepository extends JpaRepository<Poliza, Long> {

	//@Query("select p from Poliza p where p.asegurado = ?1")
	List<Poliza> findByAseguradoLike(Asegurado asegurado);
}
