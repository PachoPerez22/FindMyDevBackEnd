package cl.findmydev.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Laboral;
import cl.findmydev.web.repositories.LaboralRepository;

@Service
public class LaboralServiceImpl implements LaboralService {

	@Autowired
	private LaboralRepository laboralRepository;

	// para guardar
	@Override
	public Laboral guardarLaboral(Laboral laboral) {
		return laboralRepository.save(laboral);
	}

	// para eliminar
	@Override
	public String eliminarLaboral(Long id) {
		Boolean existe = laboralRepository.existsById(id);

		if (existe) {
			laboralRepository.deleteById(id);
		} else {
			return "dato no existe en la tabla";
		}
		return "El usuario fue eliminado";
	}

	// para actualizar
	@Override
	public Laboral actualizarLaboral(Laboral laboral) {

		Boolean existe = laboralRepository.existsById(laboral.getId());

		if (existe) {
			laboralRepository.save(laboral);
			return laboral;
		}
		return null;
	}

	@Override
	public Laboral obtenerLaboral(Long id) {
		// Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = laboralRepository.existsById(id);

		if (existe) {
			Laboral user = laboralRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public List<Laboral> obtenerListaLaboral() {
		// obtener todos los usuarios
		return laboralRepository.findAll();
	}

}
