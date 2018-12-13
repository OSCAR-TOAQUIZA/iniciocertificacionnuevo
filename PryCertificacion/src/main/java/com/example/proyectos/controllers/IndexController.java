package com.example.proyectos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Certificación II");
		model.addAttribute("framework", "Proyecto de Certificación II");		
		model.addAttribute("description", "Creacion de una plataforma de reproduccion de videos usando el modelo MVC, el frameword Spring-Boot, con JPA y Thymeleaf");
		return "index";
	}
}
