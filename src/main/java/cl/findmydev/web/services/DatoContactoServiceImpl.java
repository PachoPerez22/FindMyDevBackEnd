package cl.findmydev.web.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.DatoContacto;
import cl.findmydev.web.repositories.DatoContactoRepository;

@Service
public class DatoContactoServiceImpl implements DatoContactoService {

	@Autowired
	private DatoContactoRepository datoContactoRepository;

	@Override
	public DatoContacto guardarDatoContacto(DatoContacto datoContacto) {
		return datoContactoRepository.save(datoContacto);
	}

	@Override
	public String eliminarDatoContacto(Long id) {
		datoContactoRepository.deleteById(id);

		Optional<DatoContacto> datoContacto = datoContactoRepository.findById(id);
		if (datoContacto != null) {
			return "Usuario no eliminado";
		}
		return "El usuario fue eliminado";
	}

	@Override
	public String actualizarDatoContacto(DatoContacto datoContacto) {

		Boolean existe = datoContactoRepository.existsById(datoContacto.getId());

		if (existe) {
			datoContactoRepository.save(datoContacto);
			return "Usuario actualizado";
		}

		return "Usuario creado";
	}

	@Override
	public DatoContacto obtenerDatoContacto(Long id) {

		Boolean existe = datoContactoRepository.existsById(id);

		if (existe) {
			DatoContacto user = datoContactoRepository.findById(id).get();
			return user;
		}
		return null;
	}

}
