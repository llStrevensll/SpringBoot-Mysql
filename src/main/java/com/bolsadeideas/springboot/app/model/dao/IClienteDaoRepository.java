package com.bolsadeideas.springboot.app.model.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.model.entity.Cliente;


public interface IClienteDaoRepository extends PagingAndSortingRepository<Cliente, Long>{
	
}
