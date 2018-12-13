package com.example.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proyectos.models.dao.ITipovideoDao;
import com.example.proyectos.models.entity.Tipovideo;

@Controller
@RequestMapping("/tipovideo")
public class TipovideoController {
	
	@Autowired //Inyección de dependencias de un componente a otro componente
	private ITipovideoDao service;
	
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Categorias");
		List<Tipovideo> tipovideos = service.list();
		model.addAttribute("tipovideos", tipovideos);
		return "tipovideo/list"; //Nombre de la vista
	}	
	
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro de Nueva Categoria");
		Tipovideo tipovideo = new Tipovideo();		
		model.addAttribute("tipovideo",tipovideo);
		return "tipovideo/form";		
	}
	
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Tipovideo tipovideo = service.retrieve(id);
		model.addAttribute("tipovideo", tipovideo);
		model.addAttribute("title", tipovideo.getTipo());
		return "tipovideo/card";
	}
	
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,Model model) {
		Tipovideo tipovideo = service.retrieve(id); //Consulta la materia a traves del servicio
		model.addAttribute("tipovideo", tipovideo);
		model.addAttribute("title", "Actualizando Categoria: " + tipovideo.getTipo());
		return "tipovideo/form";		
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/tipovideo/list";		
	}
	
	@PostMapping("/form")
	private String save(Tipovideo tipovideo, Model model){	
		
		if(tipovideo.getIdtipovideo() == null)
		{
			service.create(tipovideo);
		}
		else
		{
			service.update(tipovideo);
		}			
		return "redirect:/tipovideo/list";
	}
}