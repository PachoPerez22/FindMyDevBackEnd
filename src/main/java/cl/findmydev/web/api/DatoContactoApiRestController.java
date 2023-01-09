package cl.findmydev.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.DatoContacto;
import cl.findmydev.web.services.DatoContactoServiceImpl;

@RestController
public class DatoContactoApiRestController {

	@Autowired
	private DatoContactoServiceImpl datoContactoServiceImpl;

	@RequestMapping("/guardar/datoContacto")
	public DatoContacto guardarDatoContacto(@RequestBody DatoContacto datoContacto) {
		return datoContactoServiceImpl.guardarDatoContacto(datoContacto);
	}

	@RequestMapping("/eliminar/datoContacto")
	public String eliminarDatoContacto(@RequestParam(value = "id", required = false) Long id) {

		return datoContactoServiceImpl.eliminarDatoContacto(id);
	}

	@RequestMapping("/actualizar/datoContacto")
	public String actualizarDatoContacto(@RequestBody DatoContacto datoContacto) {

		if (datoContacto.getId() != null) {
			String mensaje = datoContactoServiceImpl.actualizarDatoContacto(datoContacto);
			return mensaje;
		}
		return "no se actualizara ningun usuario";
	}

	@RequestMapping("/obtener/datoContacto")
	public DatoContacto obtenerDatoContacto(@RequestParam(value = "id", required = true) Long id) {

		return datoContactoServiceImpl.obtenerDatoContacto(id);
	}

}
