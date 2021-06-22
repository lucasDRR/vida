package ar.com.lucas.vida.asegurado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AseguradoRepository extends JpaRepository<Asegurado, Long> {

	/* query para implementar el falso login 
	 * no implementado aun
     */
	//public Optional<Asegurado> findOptionalByNombreAndApellido(String nombre, String apellido);
}
