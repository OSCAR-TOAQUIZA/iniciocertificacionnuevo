package com.example.proyectos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.proyectos.models.entity.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void create(Usuario usuario) {
		em.persist(usuario);	
	}

	@Override
	public Usuario retrieve(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	@Transactional
	public void update(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		em.remove(this.retrieve(id));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		return (List<Usuario>) em.createQuery("from Usuario").getResultList();
	}

}
