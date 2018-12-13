package com.example.proyectos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMENTARIO")
	private Integer idcomentario;
	
	@Size(max = 100)
	@Column(name = "TITULO")
	private String titulo;
	
	@Size(max = 255)
	@NotEmpty
	@Column(name = "TEXTO")
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "FECHAHORA")	
	private Date fechahora;
	
	@Size(max = 200)
	@Column(name = "OBSERVACION")
	private String observacion;

	@JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name = "IDVIDEO", referencedColumnName = "IDVIDEO")
	@ManyToOne
	private Video video;
	
	public Comentario() {}
	
	public Comentario(Integer id) {
		this.idcomentario = id;
	}
	
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechahora() {
		return fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@PrePersist
	public void prePersist(){
		this.fechahora = new Date();
	}
}