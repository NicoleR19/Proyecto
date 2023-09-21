package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Especialidad;
import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.Medico;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.services.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private MedicoService serviciomedico;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		  model.addAttribute("medico",serviciomedico.listartodos());
		  return "medico";

}
	
	@RequestMapping("/grabar")
	  public String grabar(@RequestParam("codigo") Integer cod,
			               @RequestParam("nombre") String nom,
			               @RequestParam("fechanacimiento") LocalDate fnacimiento,
			               @RequestParam("sexo") String sexo,
			               @RequestParam("estadocivil") String estadoC,
			               @RequestParam("dni") String dni,
			               @RequestParam("sueldo") double sue,
			               @RequestParam("direccionem") String direcem,
			           
	                       RedirectAttributes redirect) {
		  
		 try {
			 //crear objeto de la entidad medicamento
			 Medico med= new Medico();
			 //setear atributos del objeto med con los parametros
			 med.setNombre(nom);
			 med.setFechanacimiento(LocalDate.parse(fnacimiento));
			 med.setSexo(sexo);
			 med.setDni(dni);
			 med.setSueldo(sue);
			 med.setDireccionem(direcem);

			 
			 //validar parametro cod 
			 if(cod==0) {
			 
			 serviciomedico.registrar(med);
			 //
			 redirect.addFlashAttribute("MENSAJE", "Medico Registrado");
			 }else {
				 //setear atributo codigo
				 med.setCodigo(cod);
				 serviciomedico.actualizar(med);
				 redirect.addFlashAttribute("MENSAJE", "Medico actualizado");
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		  
		  return "redire:/medicamento/lista";
	  }
	
	}
