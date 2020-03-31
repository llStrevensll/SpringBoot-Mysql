package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.model.entity.Cliente;
import com.bolsadeideas.springboot.app.model.entity.Factura;
import com.bolsadeideas.springboot.app.model.entity.Producto;
import com.bolsadeideas.springboot.app.model.service.IClienteService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura") //Mantener factura en toda la sesion
public class FacturaController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId, Map<String, Object> model, RedirectAttributes flash) {
		
		
		Cliente cliente = clienteService.findOne(clienteId);
		
		if(cliente == null) {
			flash.addAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente); //pasar a la factura el cliente con el cual esta relacionado
		
		model.put("factura", factura);
		model.put("titulo", "Crear Factura");
	
		return "factura/form";
	}
	
	@GetMapping(value="/cargar-productos/{term}", produces= {"application/json"})
	public @ResponseBody List<Producto> cargarProducto(@PathVariable String term) { //@ResponseBody toma la respuesta convertida en json y lo registrara dentro del body de respuesta
		System.out.println(term);
		log.info(term);
		System.out.println(clienteService.findByNombre(term));
		log.info(clienteService.findByNombre(term).toString());
		return clienteService.findByNombre(term);
	}
}
