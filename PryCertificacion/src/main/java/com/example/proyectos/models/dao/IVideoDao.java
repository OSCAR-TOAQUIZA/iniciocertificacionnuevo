package com.example.proyectos.models.dao;

import java.util.List;

import com.example.proyectos.models.entity.Video;

public interface IVideoDao {
	public void create(Video video);	
	public Video retrieve(Integer id);	
	public void update(Video video);	
	public void delete(Integer id);
	
	public List<Video> list();
}
