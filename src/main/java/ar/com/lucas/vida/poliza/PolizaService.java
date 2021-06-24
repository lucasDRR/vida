package ar.com.lucas.vida.poliza;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.lucas.vida.asegurado.Asegurado;

@Service
public class PolizaService {

	@Autowired
	private PolizaRepository polizaRepo;

	// RECUPERAR 
	
	public List<Poliza> findAllPolizas() {
		return polizaRepo.findAll();
	}
	
	// Buscar una póliza por ID

	public Optional<Poliza> findPoliza(Long id) {
		return polizaRepo.findById(id);
	}

	/* Busca las polizas de un asegurado especifico, recibe asegurado
	 * como parametro de búsqueda.
	 * */

	public List<Poliza> findPolizasPorAsegurado(Asegurado asegurado) {
		return polizaRepo.findByAseguradoLike(asegurado);
	}

	/* Busca las polizas de un asegurado especifico, recibe un 'asegurado
	 * como parámetro. 
	 * Retorna una lista de PolizaDTO (no incluye beneficiarios.
	 * */

	public List<PolizaDTO> findByAseguradoDTO(Asegurado asegurado) {
		return polizaRepo.findByAsegurado(asegurado);
	}
	
	// busca una poliza por asegurado

	public List<Poliza> findPolizasPorAseguradoId(Long id) {
		return polizaRepo.findByAseguradoIdLike(id);
	}

	// GUARDAR

	public Poliza savePoliza(Poliza poliza) {
		return polizaRepo.save(poliza);
	}
	
	// MODIFICAR
	
	
	/*
	 * Modificar la suma asegurada
	 *  -> para seguros de retiro es para agregar un monto extra al
	 *     capital acumulado
	 *  -> para los demas tipo cambia la suma asegurada por un monto 
	 *     predefinido. (crear enum de montos ??)
	 * */
	public Poliza setSumaAsegurada(Long id, Integer monto) {

		Optional<Poliza> temp = polizaRepo.findById(id);

		temp.ifPresent(p -> {
			// crear un ENUM de ramas
			if (p.getCobertura().getRama().equalsIgnoreCase("retiro")) {
				p.setSuma(p.getSuma() + monto);
			} else {
				p.setSuma(monto);
			}
			polizaRepo.save(temp.get());
		});

		return temp.get();

	}
	
	/*
	 * Modifica los datos del pago
	 * -> forma de pago: debito automatico, efectivo, otros (Crear enum ??)
	 * -> medio de pago: nombre de la tarjeta, cbu o cupones ( crear enum ??)
	 * */
	
	@Transactional
	public Poliza setPago(Long id, String medioPago, String formaPago) {

		int iidd = polizaRepo.setFixedMedioPagoAndPagoFor(id, medioPago, formaPago);
		System.out.println("iidd= " + iidd);
		return polizaRepo.findById(id).get();

	}

	// BORRAR

	public void deletePoliza(Long id) {
		polizaRepo.deleteById(id);
	}

	public void deletePoliza(Poliza poliza) {
		polizaRepo.delete(poliza);
	}
}
