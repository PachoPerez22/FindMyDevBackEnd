package cl.findmydev.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Postulante;
import cl.findmydev.web.services.PostulanteServiceImpl;

@RestController
public class PostulanteApiRestController {

	@Autowired
	private PostulanteServiceImpl postulanteServiceImpl;

	@RequestMapping("/guardar/postulante")
	public Postulante guardarPostulante(@RequestBody Postulante postulante) {
		return postulanteServiceImpl.guardarPostulante(postulante);
	}

	@RequestMapping("/eliminar/postulante")
	public String eliminarPostulante(@RequestParam(value = "id", required = false) Long id) {

		return postulanteServiceImpl.eliminarPostulante(id);
	}

	@RequestMapping("/actualizar/postulante")
	public String actualizarPostulante(@RequestBody Postulante postulante) {

		if (postulante.getId() != null) {
			String mensaje = postulanteServiceImpl.actualizarPostulante(postulante);
			return mensaje;
		}
		return "no se actualizara ningun usuario";

	}

	@RequestMapping("/obtener/postulante")
	public Postulante obtenerPostulante(@RequestParam(value = "id", required = true) Long id) {

		return postulanteServiceImpl.obtenerPostulante(id);
	}

}
