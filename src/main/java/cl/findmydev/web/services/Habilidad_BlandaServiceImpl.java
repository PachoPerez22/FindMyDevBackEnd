package cl.findmydev.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Habilidad_Blanda;
import cl.findmydev.web.repositories.Habilidad_BlandaRepository;

@Service
public class Habilidad_BlandaServiceImpl implements Habilidad_BlandaService {

	@Autowired
	private Habilidad_BlandaRepository habilidad_BlandaRepository;

	// para guardar
	@Override
	public Habilidad_Blanda guardarHabilidad_Blanda(Habilidad_Blanda habilidad_Blanda) {
		return habilidad_BlandaRepository.save(habilidad_Blanda);
	}

	// para eliminar
	@Override
	public String eliminarHabilidad_Blanda(Long id) {
		Boolean existe = habilidad_BlandaRepository.existsById(id);

		if (existe) {
			habilidad_BlandaRepository.deleteById(id);
		} else {
			return "dato no existe en la tabla";
		}
		return "El usuario fue eliminado";
	}

	// para actualizar
	@Override
	public Habilidad_Blanda actualizarHabilidad_Blanda(Habilidad_Blanda habilidad_Blanda) {

		Boolean existe = habilidad_BlandaRepository.existsById(habilidad_Blanda.getId());

		if (existe) {
			habilidad_BlandaRepository.save(habilidad_Blanda);
			return habilidad_Blanda;
		}
		return null;
	}

	@Override
	public Habilidad_Blanda obtenerHabilidad_Blanda(Long id) {

		Boolean existe = habilidad_BlandaRepository.existsById(id);

		if (existe) {
			Habilidad_Blanda user = habilidad_BlandaRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public List<Habilidad_Blanda> obtenerListaHabilidad_Blanda() {
       System.out.println("habilidad_BlandaRepository.findAll();");
		return habilidad_BlandaRepository.findAll();
	}

}