package cl.findmydev.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Academica;
import cl.findmydev.web.repositories.AcademicaRepository;

@Service
public class AcademicaServiceImpl implements AcademicaService {

	@Autowired
	private AcademicaRepository academicaRepository;

	// para guardar
	@Override
	public Academica guardarAcademica(Academica academica) {
		return academicaRepository.save(academica);
	}

	// para eliminar
	@Override
	public String eliminarAcademica(Long id) {
		Boolean existe = academicaRepository.existsById(id);

		if (existe) {
			academicaRepository.deleteById(id);
		} else {
			return "dato no existe en la tabla";
		}
		return "El usuario fue eliminado";
	}

	// para actualizar
	@Override
	public Academica actualizarAcademica(Academica academica) {

		Boolean existe = academicaRepository.existsById(academica.getId());

		if (existe) {
			academicaRepository.save(academica);
			return academica;
		}
		return null;
	}

	@Override
	public Academica obtenerAcademica(Long id) {

		Boolean existe = academicaRepository.existsById(id);

		if (existe) {
			Academica user = academicaRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public List<Academica> obtenerListaAcademica() {

		return academicaRepository.findAll();
	}

}
