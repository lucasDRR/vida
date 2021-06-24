package ar.com.lucas.vida.asegurado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AseguradoService {

	@Autowired(required = true)
	private AseguradoRepository asRepo;

	// RECUPERAR ASEGURADOS
	
	public List<Asegurado> findAllAsegurados() {
		return asRepo.findAll();
	}

	public Optional<Asegurado> findAsegurado(Long id) {
		return asRepo.findById(id);
	}

	public AseguradoLoginDTO findAseguradoByDni(Integer dni) {
		return this.asRepo.findOptionalByDni(dni).orElse(null);
	}

	// AGREGAR ASEGURADO

	public Asegurado saveAsegurado(Asegurado aseg) {

		aseg.setNombre(aseg.getNombre().toLowerCase());
		// if(aseg.getEdad() < 16) // tirar error
		// if(aseg.getEdad() > 65) // tirar error

		return asRepo.save(aseg);
	}

	// MODIFICAR ASEGURADO
	
	@Transactional
	public Optional<Asegurado> updateUsuario(Long id, Asegurado asegurado) {

		// Modificar con query transaccional
		if (id == null)
			return Optional.empty();

		Optional<Asegurado> temp = asRepo.findById(id);

		temp.ifPresent(p -> {
			p.setNombre(asegurado.getNombre());
			p.setEdad(asegurado.getEdad());
			p.setDni(asegurado.getDni());
			p.setGenero(asegurado.getGenero());
			p.setDireccion(asegurado.getDireccion());

			asRepo.save(temp.get());
		});

		return temp;
	}

	// BORRAR ASEGURADO

	public void deleteAsegurado(Long id) {
		asRepo.deleteById(id);
	}

}
