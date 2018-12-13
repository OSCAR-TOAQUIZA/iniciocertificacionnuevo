package com.example.proyectos.models.dao;

import java.util.List;

import com.example.proyectos.models.entity.Comentario;

public interface IComentarioDao {
	public void create(Comentario comentario);	
	public Comentario retrieve(Integer id);	
	public void update(Comentario comentario);	
	public void delete(Integer id);
	
	public List<Comentario> list();
}
