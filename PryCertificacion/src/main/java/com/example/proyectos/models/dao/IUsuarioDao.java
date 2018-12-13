package com.example.proyectos.models.dao;

import java.util.List;

import com.example.proyectos.models.entity.Usuario;

public interface IUsuarioDao {
	
	public void create(Usuario usuario);	
	public Usuario retrieve(Integer id);	
	public void update(Usuario usuario);	
	public void delete(Integer id);
	
	public List<Usuario> list();
}
