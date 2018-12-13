package com.example.proyectos.models.dao;

import java.util.List;

import com.example.proyectos.models.entity.Tipovideo;

public interface ITipovideoDao {
	public void create(Tipovideo tipovideo);	
	public Tipovideo retrieve(Integer id);	
	public void update(Tipovideo tipovideo);	
	public void delete(Integer id);
	
	public List<Tipovideo> list();
}
