package cl.findmydev.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Rol;
import cl.findmydev.web.repositories.RolRepository;


@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Rol guardarRol(Rol rol) {
		rolRepository.save(rol);
		return null;
	}

	public Rol obtenerRol(Long id) {
		Boolean existe = rolRepository.existsById(id);

		if (existe) {
			Rol rol = rolRepository.findById(id).get();
			return rol;
		}
		return null;
	}
}
