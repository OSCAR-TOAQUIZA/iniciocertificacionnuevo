package com.example.proyectos.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.proyectos.models.entity.Video;

@Repository
public class VideoDao implements IVideoDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void create(Video video) {
		em.persist(video);
	}

	@Override
	public Video retrieve(Integer id) {
		return em.find(Video.class, id);
	}

	@Override
	@Transactional
	public void update(Video video) {
		em.merge(video);		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		em.remove(this.retrieve(id));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> list() {
		return (List<Video>) em.createQuery("from Video").getResultList();
	}

}