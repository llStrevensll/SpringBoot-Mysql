package com.bolsadeideas.springboot.app.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="facturas_items")
public class ItemFactura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY) //de manera automatica se creara producto_id, pero tambien se puede especificar de forma explicita con JoinColumn
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double calcularImporte() {
		return cantidad.doubleValue() * producto.getPrecio();  //convetir a long-> longValue , Double -> doubleValue
	}
	
	
}
