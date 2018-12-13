package com.example.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.proyectos.models.dao.IUsuarioDao;
import com.example.proyectos.models.entity.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired //Inyección de dependencias de un componente a otro componente
	private IUsuarioDao service;
	
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Usuarios");
		List<Usuario> usuarios = service.list();
		model.addAttribute("usuarios", usuarios);
		return "usuario/list"; //Nombre de la vista
	}	
	
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro de Nuevo Usuario");
		Usuario usuario = new Usuario();		
		model.addAttribute("usuario",usuario);
		return "usuario/form";		
	}
	
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Usuario usuario = service.retrieve(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", usuario.getNombre());
		return "usuario/card";
	}
	
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,Model model) {
		Usuario usuario = service.retrieve(id); //Consulta la materia a traves del servicio
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Actualizando Datos del Usuario: " + usuario.getNombre());
		return "usuario/form";		
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/usuario/list";		
	}
	
	@PostMapping("/form")
	private String save(Usuario usuario, Model model){
		
		if(usuario.getIdusuario() == null)
		{
			service.create(usuario);
		}
		else
		{
			service.update(usuario);
		}		
		return "redirect:/usuario/list";
	}
}