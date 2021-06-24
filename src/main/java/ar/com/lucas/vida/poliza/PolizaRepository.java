package ar.com.lucas.vida.poliza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ar.com.lucas.vida.asegurado.Asegurado;

public interface PolizaRepository extends JpaRepository<Poliza, Long> {

	List<Poliza> findByAseguradoLike(Asegurado asegurado);
	
	List<PolizaDTO> findByAsegurado(Asegurado asegurado);
	
	List<Poliza> findByAseguradoIdLike(Long id);

	
	@Modifying(clearAutomatically = true)
	@Query("update Poliza p set p.medioPago = ?2, p.pago = ?3 where p.id = ?1")
	int setFixedMedioPagoAndPagoFor(Long id, String medioPago, String formaPago);

}
