package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.findmydev.web.models.Reclutador;
import cl.findmydev.web.repositories.ReclutadorRepository;

@Service
public class ReclutadorServiceImpl implements ReclutadorService {
	
	
@Autowired
private ReclutadorRepository reclutadorRepository;

@Override
public Reclutador guardarReclutador(Reclutador reclutador) {
	return reclutadorRepository.save(reclutador);
}


//eliminar dato empresa
	@Override
	public String eliminarReclutador(Long id) {
		Boolean existe = reclutadorRepository.existsById(id);

		if (existe) {

		reclutadorRepository.deleteById(id);
			;
		}

		else {
			return "no se encuentra";
		}

		existe = reclutadorRepository.existsById(id);

		if (existe) {

			return "error";
		}

		return "borrado exitosamente";

	}
	
	
	
	
	@Override
	public String actualizarReclutador(Reclutador reclutador) {
		Boolean existe = reclutadorRepository.existsById(reclutador.getId());

		if (existe) {
			reclutadorRepository.save(reclutador);
			return " Su Proyecto se ah Actualizado Exitosamente";
		}
		return "No se ah encontrado el id del proyecto No se puede Actualizar";
	}
	
	
	
	

	@Override
	public List<Reclutador> listarReclutador() {
		return reclutadorRepository.findAll();
	}

	
	
	@Override
	public Optional<Reclutador> obtenerReclutador(Long id) {
		Optional<Reclutador> datoRe = reclutadorRepository.findById(id);
		return datoRe;
	}




}