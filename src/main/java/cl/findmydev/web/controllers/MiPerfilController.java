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
import cl.findmydev.web.models.Laboral;
import cl.findmydev.web.models.Usuario;
import cl.findmydev.web.services.Habilidad_BlandaServiceImpl;
import cl.findmydev.web.services.LaboralServiceImpl;
import cl.findmydev.web.services.UsuarioServiceImpl;


@Controller
@RequestMapping("/miPerfil")
public class MiPerfilController {
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	LaboralServiceImpl laboralServiceImpl;
	
	@Autowired
	Habilidad_BlandaServiceImpl habilidadblandaServiceImpl;
	
	@GetMapping ("")
	public String miPerfil() {
		
		
		return "miPerfil.jsp";
	}
	
	@GetMapping ("/datoslaborales")
	public String datosLaboral(Model model) {
		//inyecto traer toda la lista autos en esta vista
			List<Laboral> listaLaboral=	laboralServiceImpl.obtenerListaLaboral();
			//pasar al JSP
			model.addAttribute("listaLaboral",listaLaboral);
		
		return "laboral.jsp";
	}
	
	@PostMapping("/datoslaborales")
	public String guardarFormLaboral(@RequestParam ("nombre")String nombre,
			@RequestParam("descripcion")String descripcion,
			
			Model model,
			HttpSession session) {
		String correo = (String) session.getAttribute("usuarioCorreo");
		Usuario usuario = usuarioServiceImpl.obtenerUsuarioCorreo(correo);
		
		Laboral laboral = new Laboral();
		laboral.setNombre(nombre);
		laboral.setDescripcion(descripcion);

		laboralServiceImpl.guardarLaboral(laboral);
		model.addAttribute(laboral);
		return "redirect:/datoslaborales";
		
	}
	
/*	@PostMapping("/habilidadesBlandas")
	public String guardarselectHB(@RequestParam("optionselect") Habilidad_Blanda habilidad_Blanda,
			Model model,
			HttpSession session) {
		String correo = (String) session.getAttribute("usuarioCorreo");
		Usuario usuario = usuarioServiceImpl.obtenerUsuarioCorreo(correo);
		
		
		
	}*/
	
	
	@GetMapping ("/habilidadesBlandas")
	public String habilidades_blandasLista(Model model) {
		//inyecto traer toda la lista autos en esta vista
			List<Habilidad_Blanda> listaHBlandas= habilidadblandaServiceImpl.obtenerListaHabilidad_Blanda() ;
			//pasar al JSP
			model.addAttribute("listaHBlandas",listaHBlandas);
		
		return "habilidades_blandas.jsp";
	}
	
	
	
	
}
