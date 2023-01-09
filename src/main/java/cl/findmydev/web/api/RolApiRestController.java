package cl.findmydev.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Rol;
import cl.findmydev.web.models.Usuario;
import cl.findmydev.web.services.RolServiceImpl;



@RestController
public class RolApiRestController {

	@Autowired
	RolServiceImpl rolServiceImpl;
	
	@RequestMapping("/obtener/rol")
	public Rol obtenerUsuario(@RequestParam(value="id",required = true) Long id) {
		Rol rol = rolServiceImpl.obtenerRol(id);
		// uso de lazy
		// obteniedo la lista de usuarios para el mismo rol
		List<Usuario> usuarios= (List<Usuario>) rol.getUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}
		return rol;
	}
	
	
	@RequestMapping("/guardar/rol")
	public Rol guardarPostulante(@RequestBody Rol rol) {
		return rolServiceImpl.guardarRol(rol);
	}
}
