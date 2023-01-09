package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.DatoEmpresa;
import cl.findmydev.web.repositories.DatoEmpresaRepository;

@Service
public class DatoEmpresaServiceImpl implements DatoEmpresaService {

	@Autowired
	private DatoEmpresaRepository datoEmpresaRepository;

	@Override
	public DatoEmpresa guardarDatoEmpresa(DatoEmpresa datoEmpresa) {
		return datoEmpresaRepository.save(datoEmpresa);
	}

	// eliminar dato empresa
	@Override
	public String eliminarDatoEmpresa(Long id) {
		Boolean existe = datoEmpresaRepository.existsById(id);

		if (existe) {

			datoEmpresaRepository.deleteById(id);
			;
		}

		else {
			return "no se encuentra";
		}

		existe = datoEmpresaRepository.existsById(id);

		if (existe) {

			return "error";
		}

		return "borrado exitosamente";

	}

//actualizar---------------------------------------------------

	@Override
	public String actualizarDatoEmpresa(DatoEmpresa datoEmpresa) {
		Boolean existe = datoEmpresaRepository.existsById(datoEmpresa.getId());

		if (existe) {
			datoEmpresaRepository.save(datoEmpresa);
			return " Su Proyecto se ah Actualizado Exitosamente";
		}
		return "No se ah encontrado el id del proyecto No se puede Actualizar";
	}

	@Override
	public List<DatoEmpresa> listarDatoEmpresas() {
		return datoEmpresaRepository.findAll();
	}

	@Override
	public Optional<DatoEmpresa> obtenerEmpresa(Long id) {
		Optional<DatoEmpresa> datoEm = datoEmpresaRepository.findById(id);
		return datoEm;
	}

}