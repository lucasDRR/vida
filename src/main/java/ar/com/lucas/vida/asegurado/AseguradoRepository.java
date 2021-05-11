package ar.com.lucas.vida.asegurado;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AseguradoRepository extends JpaRepository<Asegurado, Long> {

	public Asegurado findByNombre(String nombre);
}
