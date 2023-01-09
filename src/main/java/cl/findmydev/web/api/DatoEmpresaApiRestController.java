package cl.findmydev.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.DatoEmpresa;
import cl.findmydev.web.services.DatoEmpresaServiceImpl;

@RestController
public class DatoEmpresaApiRestController {

	@Autowired
	private DatoEmpresaServiceImpl datoEmpresaServiceImpl;

	// http://localhost:8080/guardar/academica
	@RequestMapping("/guardar/datoEmpresa")
	public DatoEmpresa guardarDatoEmpresa(@RequestBody DatoEmpresa datoEmpresa) {
		return datoEmpresaServiceImpl.guardarDatoEmpresa(datoEmpresa);

	}

	@RequestMapping("/eliminar/datoEmpresa")
	public String eliminarDatoEmpresa(@RequestParam(value = "id", required = true) Long id) {

		return datoEmpresaServiceImpl.eliminarDatoEmpresa(id);

	}

	@RequestMapping("/actualizar/datoEmpresa")
	public String actualizarDatoEmpresa(@RequestBody DatoEmpresa datoEmpresa) {
		String mensaje = datoEmpresaServiceImpl.actualizarDatoEmpresa(datoEmpresa);
		return mensaje;
	}

	@RequestMapping("/listar/datoEmpresa")
	public List<DatoEmpresa> datoempresa() {

		return datoEmpresaServiceImpl.listarDatoEmpresas();

	}

	@RequestMapping("/obtener/datoEmpresa")
	public Optional<DatoEmpresa> obtenerEmpresa(@RequestParam(value = "id", required = true) Long id) {

		return datoEmpresaServiceImpl.obtenerEmpresa(id);
	}

}
