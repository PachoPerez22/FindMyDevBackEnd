package cl.findmydev.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.findmydev.web.models.Habilidad_Blanda;
import cl.findmydev.web.models.Postulante;
import cl.findmydev.web.services.Habilidad_BlandaServiceImpl;
import cl.findmydev.web.services.PostulanteServiceImpl;
import cl.findmydev.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	Habilidad_BlandaServiceImpl habilidad_blandaServiceImpl;
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping ("")
	public String home(Model model, HttpSession session) {

		if(session.getAttribute("usuarioId")!=null) {
			
		//	List<Postulante> listaPostulantes= postulanteServiceImpl.listaPostulantes();
			//model.addAttribute("listaPostulantes", listaPostulantes);
			
		//	List<Habilidad_Blanda> obtenerListaHabilidad_Blanda = habilidad_blandaServiceImpl.obtenerListaHabilidad_Blanda();
		//	model.addAttribute("obtenerListaHabilidad_Blanda", obtenerListaHabilidad_Blanda);
			
			//model.addAttribute("habilidad_blandaSeleccionada" ,null);
			List<Habilidad_Blanda>listaHBlandas=habilidad_blandaServiceImpl.obtenerListaHabilidad_Blanda();
			System.out.println(listaHBlandas);
			model.addAttribute("listaHBlandas", listaHBlandas);
			
			return "home.jsp";
		}else {
			return "login_final.jsp";
		}
		
	}
	
//	@PostMapping("/habilidad_blanda")
//	public String buscarPorHabilidadBlanda(@RequestParam("habilidad_blandaSeleccionada")Long id ,Model model) {
		
	//	List<Habilidad_Blanda> obtenerListaHabilidad_Blanda = habilidad_blandaServiceImpl.obtenerListaHabilidad_Blanda();
	//	model.addAttribute("obtenerListaHabilidad_Blanda",obtenerListaHabilidad_Blanda);
		
	//	List<Postulante> listaPostulantes = postulanteServiceImpl.buscarPorHabilidadBlanda(id);
	//	model.addAttribute("listaPostulantes",listaPostulantes);
		
	//	return "home.jsp";
//	}
	
}
