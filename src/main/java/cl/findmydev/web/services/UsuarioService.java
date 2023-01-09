package cl.findmydev.web.services;

import cl.findmydev.web.models.Usuario;

public interface UsuarioService {

	public Boolean guardarUsuario(Usuario usuario);

	public String eliminarUsuario(Long id);

	public String actualizarUsuario(Usuario usuario);

	public Usuario obtenerUsuario(Long id);
	
	public Boolean ingresoUsuario(String correo, String password);
	
	public Usuario obtenerUsuarioCorreo(String correo);
}
