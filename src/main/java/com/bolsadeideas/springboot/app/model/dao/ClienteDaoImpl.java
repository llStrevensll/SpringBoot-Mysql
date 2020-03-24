package com.bolsadeideas.springboot.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.model.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}
	
	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}
	
	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) { //actualizar
			em.merge(cliente);
		} else { //sino hay id entonces crear
			em.persist(cliente);
		}
		
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
