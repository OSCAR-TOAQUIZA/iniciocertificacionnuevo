package com.example.proyectos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.proyectos.models.entity.Comentario;
import com.example.proyectos.models.entity.Usuario;

@Repository
public class ComentarioDao implements IComentarioDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void create(Comentario comentario) {
		em.persist(comentario);		
	}

	@Override
	public Comentario retrieve(Integer id) {
		return em.find(Comentario.class, id);
	}

	@Override
	@Transactional
	public void update(Comentario comentario) {
		em.merge(comentario);		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		em.remove(this.retrieve(id));		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> list() {
		return (List<Comentario>) em.createQuery("from Comentario").getResultList();
	}

}
