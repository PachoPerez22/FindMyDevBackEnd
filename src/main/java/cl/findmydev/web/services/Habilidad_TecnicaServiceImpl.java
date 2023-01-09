package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Habilidad_Tecnica;
import cl.findmydev.web.repositories.Habilidad_TecnicaRepository;

@Service
public class Habilidad_TecnicaServiceImpl implements Habilidad_TecnicaService {

	@Autowired
	private Habilidad_TecnicaRepository habilidad_tecnicaRepository;

	@Override
	public Habilidad_Tecnica guardarHabilidad_Tecnica(Habilidad_Tecnica habilidad_tecnica) {
		return habilidad_tecnicaRepository.save(habilidad_tecnica);
	}

	// eliminar
	@Override
	public String eliminarHabilidad_Tecnica(Long id) {
		Boolean existe = habilidad_tecnicaRepository.existsById(id);
		if (existe) {
			habilidad_tecnicaRepository.deleteById(id);
		} else {
			return "No se encuentra Registrada esa Habilidad Tecnica";
		}

		existe = habilidad_tecnicaRepository.existsById(id);
		if (existe) {
			return "Hay un error no se puede eliminar esa Habilidad tecnica ";
		}

		return "Se ah eliminado tu Habilidad Tecica Exitsamente";
	}

	@Override
	public String actualizarHabilidad_Tecnica(Habilidad_Tecnica habilidad_tecnica) {
		Boolean existe = habilidad_tecnicaRepository.existsById(habilidad_tecnica.getId());
		if (existe) {
			habilidad_tecnicaRepository.save(habilidad_tecnica);
			return "Su Habilidad tecnica ah sido actualizada Exitosamente";
		}
		return "No se ah podido Actualizar su Habilidad tecnica";
	}

	@Override
	public Optional<Habilidad_Tecnica> obtenerHabilidad_Tecnica(Long id) {
		Optional<Habilidad_Tecnica> habilidadTec = habilidad_tecnicaRepository.findById(id);
		return habilidadTec;
	}

	@Override

	public List<Habilidad_Tecnica> TodoHabilidadTecnica() {
		return habilidad_tecnicaRepository.findAll();
	}
}
