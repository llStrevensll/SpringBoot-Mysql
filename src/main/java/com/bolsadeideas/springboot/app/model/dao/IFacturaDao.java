package com.bolsadeideas.springboot.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.model.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
