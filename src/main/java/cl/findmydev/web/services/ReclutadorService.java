package cl.findmydev.web.services;	

import java.util.List;
import java.util.Optional;

import cl.findmydev.web.models.Reclutador;
	
public interface ReclutadorService {
		public Reclutador guardarReclutador(Reclutador reclutador);

		public String eliminarReclutador(Long id);

		public String actualizarReclutador(Reclutador reclutador);

		public List<Reclutador> listarReclutador();

		public Optional<Reclutador> obtenerReclutador(Long id);

	

	

		

	}

	
	
	
	


