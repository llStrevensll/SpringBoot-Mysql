package com.bolsadeideas.springboot.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	//@Size(min=4, max=12)
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Column(name="create_at")
	@Temporal(TemporalType.DATE) //Indicar el formato en que se va a guardar - .DATE solo la fecha
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	//mappedBy = "cliente" - crea de forma automatica la llave foranea cliente_id en la tabla facturas
	@OneToMany(mappedBy = "cliente" ,fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true) //Lazy- carga perezosa, cascade- en secuencia Ej: si el cliente se elimina tambien se elminan todas su facturas, si se persiste el cliente tambien sus elementos hijos, orphanRemoval->sirve ára eliminar registros huerfanos que no estan asociados a ningun cliente
	private List<Factura> facturas;//Un cliente puede tener muchas facturas - por ello lista de facturas
	
	private String foto;
	
	/*
	// Ejecutar antes de realizar la persistencia en la base de datos
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}*/
	
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	// Adicionar factura a la lista
	public void addFactura(Factura factura) {
		facturas.add(factura);
	}


	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
	
	
	

	
	
}
