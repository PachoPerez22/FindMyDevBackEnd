package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Postulante;
import cl.findmydev.web.repositories.PostulanteRepository;

@Service
public class PostulanteServiceImpl implements PostulanteService {

	@Autowired
	private PostulanteRepository postulanteRepository;

	@Override
	public Postulante guardarPostulante(Postulante postulante) {
		return postulanteRepository.save(postulante);
	}

	@Override
	public String eliminarPostulante(Long id) {
		postulanteRepository.deleteById(id);

		Optional<Postulante> postulante = postulanteRepository.findById(id);
		if (postulante != null) {
			return "Usuario no eliminado";
		}
		return "El usuario fue eliminado";
	}

	@Override
	public String actualizarPostulante(Postulante postulante) {

		Boolean existe = postulanteRepository.existsById(postulante.getId());

		if (existe) {
			postulanteRepository.save(postulante);
			return "Usuario actualizado";
		}

		return "Usuario creado";
	}

	@Override
	public Postulante obtenerPostulante(Long id) {

		Boolean existe = postulanteRepository.existsById(id);

		if (existe) {
			Postulante user = postulanteRepository.findById(id).get();
			return user;
		}
		return null;
	}
	
	public List<Postulante> listaPostulantes(){
		return postulanteRepository.findAll();
	}
	
	
	//@Override
	//public List<Postulante> buscarPorHabilidadBlanda(Long id){
	//	return postulanteRepository.buscarPorHabilidadBlanda(id);
	//}

}
