package ar.com.lucas.vida.asegurado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AseguradoService {

	@Autowired(required=true)
	private AseguradoRepository asRepo;

	// RECUPERAR asegurados
	public List<Asegurado> findAllAsegurados(){
		return asRepo.findAll();
	}

	public Optional<Asegurado> findAsegurado(Long id){

		Optional<Asegurado> temp = asRepo.findById(id);
		return temp;
	}

//	public Optional<Asegurado> findAseguradoByNames(String nombre, String apellido){
//		return this.asRepo.findOptionalByNombreAndApellido(nombre, apellido);
//	}

	//AGREGAR ASEGURADO

	public Asegurado saveAsegurado(Asegurado aseg) {
		//modificar para retornar un Optional<Asegurado>
		return asRepo.save(aseg);
	}

	// MODIFICAR ASEGURADO

	public Optional<Asegurado> updateUsuario(Long id, Asegurado asegurado) {

		//Modificar con query transaccional
		if(id == null ) return Optional.empty();

		Optional<Asegurado> temp =  asRepo.findById(id);

		temp.ifPresent(p -> {
			p.setNombre( asegurado.getNombre() );
			p.setEdad( asegurado.getEdad() );
			p.setDireccion( asegurado.getDireccion() );

			asRepo.save(temp.get());
		});

		return temp;
	}

	// BORRAR ASEGURADO

	public void deleteAsegurado(Long id) {
		asRepo.deleteById(id);
	}

}
