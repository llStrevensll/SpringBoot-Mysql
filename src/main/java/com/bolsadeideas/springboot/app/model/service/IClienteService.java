package com.bolsadeideas.springboot.app.model.service;

import java.util.List;

import com.bolsadeideas.springboot.app.model.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
