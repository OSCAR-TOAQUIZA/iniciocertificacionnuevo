package com.example.proyectos.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIPOVIDEO")
public class Tipovideo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTIPOVIDEO")
	private Integer idtipovideo;
	
	@Size(max = 60)
	@NotEmpty
	@Column(name = "TIPO")
	private String tipo;
	
	@Size(max = 200)
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@OneToMany(mappedBy= "tipovideo",fetch=FetchType.LAZY)	
	private List<Video> videos;
	
	public Tipovideo() {
		videos = new ArrayList<Video>();
	}
	
	public Tipovideo(Integer id) {
		videos = new ArrayList<Video>();
		this.idtipovideo = id;
	}

	public Integer getIdtipovideo() {
		return idtipovideo;
	}

	public void setIdtipovideo(Integer idtipovideo) {
		this.idtipovideo = idtipovideo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}