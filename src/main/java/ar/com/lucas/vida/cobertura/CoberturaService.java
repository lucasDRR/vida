package ar.com.lucas.vida.cobertura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoberturaService {
	
	@Autowired
	private CoberturaRepository coRepo;
	
	// RECUPERAR
	
	public List<Cobertura> findAllCobertura(){
		return coRepo.findAll();
	}
	
	
	public Optional<Cobertura> findCobertura(Long id){
		return coRepo.findById(id);
	}
	
	public List<Cobertura> findByRama(String rama){
		return coRepo.findByRamaLike(rama);
	}
	
	// GUARDAR
	
	public Cobertura saveCobertura( Cobertura cobertura) {
		
		return coRepo.save(cobertura);
	}
	
	// MODIFICAR
	
	public Optional<Cobertura> updateCobertura(Cobertura cobertura, Long id){
		
		if(id == null ) return Optional.empty();

		Optional<Cobertura> temp =  coRepo.findById(id);

		temp.ifPresent(p -> {
			
			p.setNombre( cobertura.getNombre() );
			p.setRama( cobertura.getRama() );
			
			coRepo.save(temp.get());
		});

		return temp;
	}
	
	// BORRAR
	
	public void deleteCobertura(Long id) {
		
		coRepo.deleteById(id);
	}
	
	public void deleteByCobertura(Cobertura cobertura) {
		
		coRepo.delete(cobertura);
	}

}
