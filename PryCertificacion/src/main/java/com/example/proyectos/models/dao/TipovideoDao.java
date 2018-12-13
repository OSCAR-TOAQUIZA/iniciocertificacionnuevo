package com.example.proyectos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.proyectos.models.entity.Tipovideo;

@Repository
public class TipovideoDao implements ITipovideoDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void create(Tipovideo tipovideo) {
		em.persist(tipovideo);			
	}

	@Override
	public Tipovideo retrieve(Integer id) {
		return em.find(Tipovideo.class, id);
	}

	@Override
	@Transactional
	public void update(Tipovideo tipovideo) {
		em.merge(tipovideo);		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		em.remove(this.retrieve(id));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipovideo> list() {
		return (List<Tipovideo>) em.createQuery("from Tipovideo").getResultList();
	}
}