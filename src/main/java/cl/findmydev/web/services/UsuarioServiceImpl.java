package cl.findmydev.web.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Postulante;
import cl.findmydev.web.models.Usuario;
import cl.findmydev.web.repositories.PostulanteRepository;
import cl.findmydev.web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private PostulanteRepository postulanteRepository;

	@Override
	public Boolean guardarUsuario(Usuario usuario) {
	

		Usuario retornoUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
		if(retornoUsuario==null) {
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			
			usuario.setPassword(passHashed);
			
			usuarioRepository.save(usuario);
			
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);

		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario != null) {
			return "Usuario no eliminado";
		}
		return "El usuario fue eliminado";
	}

	@Override
	public String actualizarUsuario(Usuario usuario) {

		Boolean existe = usuarioRepository.existsById(usuario.getId());

		if (existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}

		return "Usuario creado";
	}

	@Override
	public Usuario obtenerUsuario(Long id) {

		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public Boolean ingresoUsuario(String correo, String password) {
		
		Usuario usuario = usuarioRepository.findByCorreo(correo);
		
		if (usuario!=null) {
			
			return BCrypt.checkpw(password, usuario.getPassword());
			
		}else {
			return false;	
		}				
	}
	
	@Override
	public Usuario obtenerUsuarioCorreo(String correo) {
		
		return usuarioRepository.findByCorreo(correo);
	}
}
