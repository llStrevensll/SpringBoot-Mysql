package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.model.entity.Cliente;
import com.bolsadeideas.springboot.app.model.entity.Factura;
import com.bolsadeideas.springboot.app.model.entity.ItemFactura;
import com.bolsadeideas.springboot.app.model.entity.Producto;
import com.bolsadeideas.springboot.app.model.service.IClienteService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura") //Mantener factura en toda la sesion
public class FacturaController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value="id") Long id,
				Model model,
				RedirectAttributes flash) {
		//Obtener id
		Factura factura = clienteService.findFacturaById(id);
		
		if(factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
			return "redirect:/listar";
		}
		
		model.addAttribute("titulo", "Factura : ".concat(factura.getDescripcion()));
		model.addAttribute("factura", factura);
		
		return "factura/ver";
	}
	
	
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
	
	//Factura -> Objeto del formulario , Arreglos con Items Id y Cantidad
	@PostMapping("/form")
	public String guardar(@Valid Factura factura,
							BindingResult result,
							Model model,
							@RequestParam(name="item_id[]", required=false) Long[] itemId, 
							@RequestParam(name="cantidad[]", required=false) Integer[] cantidad,
							RedirectAttributes flash,
							SessionStatus status) {
		//Si tiene errores
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear Factura");
			return "factura/form";
		}
		
		//Si es nulo o vacio
		if(itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura debe contener lineas");
			return "factura/form";
		}
		
		for(int i = 0; i < itemId.length; i++) {
			//Buscar producto por id
			Producto producto = clienteService.findProductoById(itemId[i]);
			
			//Crear linea de la factura con la cantidad y el producto
			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			
			//Adicionar la linea a la Factura
			factura.addItemFactura(linea);
			
			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}
		
		clienteService.saveFactura(factura); //Guardar Factura
		status.setComplete(); //Finalizar sesion de factura
		
		flash.addFlashAttribute("success", "Factura creada con éxito!");
		return "redirect:/ver/" + factura.getCliente().getId();
	}
}
