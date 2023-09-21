package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.services.MedicamentoServices;
import com.project.consorcio.services.TipoMedicamentoService;

//anotacion que indica que la clase es un controlador, por lo tanto
//permite recibir peticiones de los clientes y envia respuesta.
@Controller
//permite crear una direccion url o ruta para acceder al controlador
@RequestMapping("/medicamento")
public class MedicamentoController {
  @Autowired
  private MedicamentoServices servicioMed;
  
  @Autowired 
  private TipoMedicamentoService servicioTipo;
  
  @RequestMapping("/lista")
  //model es una interface que permite crear atributos que luego seran enviados a la pagina
  public String index(Model model) {
	  model.addAttribute("medicamentos",servicioMed.listartodos());
	  model.addAttribute("tipos",servicioTipo.listarTodos());
	  return "medicamento";
	  
  }
  //requestmaping, permite recuperar valores que se encuetran en los controles del formulario(cajas,checkbox,radio,etc)
  @RequestMapping("/grabar")
  public String grabar(@RequestParam("codigo") Integer cod,
		               @RequestParam("nombre") String nom,
		               @RequestParam("des") String des,
		               @RequestParam("stock") int stock,
		               @RequestParam("precio") double pre,
		               @RequestParam("fecha") String fec,
		               @RequestParam("tipo") int codtipo,
                       RedirectAttributes redirect) {
	  
	 try {
		 //crear objeto de la entidad medicamento
		 Medicamento med= new Medicamento();
		 //setear atributos del objeto med con los parametros
		 med.setNombre(nom);
		 med.setDes(des);
		 med.setStock(stock);
		 med.setPrecio(pre);
		 med.setFecha(LocalDate.parse(fec));
		 //crear un objeto de la entidad tipomedicamento
		 TipoMedicamento tm = new TipoMedicamento();
		 //setear atributo codigo del objeto "tm" con el parameto
		 tm.setCodigo(codtipo);
		 med.setTipo(tm);
		 
		 //validar parametro cod 
		 if(cod==0) {
		 
		 servicioMed.registrar(med);
		 //
		 redirect.addFlashAttribute("MENSAJE", "Medicamento Registrado");
		 }else {
			 //setear atributo codigo
			 med.setCodigo(cod);
			 servicioMed.actualizar(med);
			 redirect.addFlashAttribute("MENSAJE", "Medicamento actualizado");
		 }
		 
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	  
	  return "redire:/medicamento/lista";
  }
  
  //crear ruta o direccio url para buscar medicamento segun codigo
  @RequestMapping("/buscar")
  @ResponseBody
  public Medicamento buscar(@RequestParam("codigo") Integer cod) {
	  return servicioMed.buscarPorID(cod);
	  
  }
  
}
