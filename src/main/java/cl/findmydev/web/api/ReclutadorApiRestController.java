package cl.findmydev.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Reclutador;
import cl.findmydev.web.services.ReclutadorServiceImpl;

@RestController
public class ReclutadorApiRestController {

	@Autowired
	private ReclutadorServiceImpl reclutadorServiceImpl;

	// http://localhost:8080/guardar/academica
	@RequestMapping("/guardar/reclutador")
	public Reclutador guardarReclutador(@RequestBody Reclutador reclutador) {
		return reclutadorServiceImpl.guardarReclutador(reclutador);

	}

	@RequestMapping("/eliminar/reclutador")
	public String eliminarReclutador(@RequestParam(value = "id", required = true) Long id) {

		return reclutadorServiceImpl.eliminarReclutador(id);

	}

	@RequestMapping("/actualizar/reclutador")
	public String actualizarReclutador(@RequestBody Reclutador reclutador) {
		String mensaje = reclutadorServiceImpl.actualizarReclutador(reclutador);
		return mensaje;
	}

	@RequestMapping("/listar/reclutador")
	public List<Reclutador> reclutador() {

		return reclutadorServiceImpl.listarReclutador();

	}

	@RequestMapping("/obtener/reclutador")
	public Optional<Reclutador> reclutador(@RequestParam(value = "id", required = true) Long id) {

		return reclutadorServiceImpl.obtenerReclutador(id);
	}

}
