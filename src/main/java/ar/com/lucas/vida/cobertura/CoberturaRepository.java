package ar.com.lucas.vida.cobertura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface CoberturaRepository extends JpaRepository<Cobertura, Long> {

	List<Cobertura> findByRamaLike(String rama);

}
