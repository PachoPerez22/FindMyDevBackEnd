package cl.findmydev.web.services;

import cl.findmydev.web.models.Rol;

public interface RolService {

	public Rol obtenerRol(Long id);

	public Rol guardarRol(Rol rol);

	
}
