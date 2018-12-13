package com.example.proyectos.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VIDEO")
public class Video implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDVIDEO")
	private Integer idvideo;
	
	@Size(max = 60)
	@NotEmpty
	@Column(name = "TITULO")
	private String titulo;
	
	@Size(max = 100)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ESTADO")
	private Boolean estado;
	
	@Size(max = 100)
	@Column(name = "RUTAIMAGEN")
	private String rutaimagen;
	
	@Size(max = 100)
	@Column(name = "RUTAVIDEO")
	private String rutavideo;
	
	@Column(name = "CONTADOR")
	private Integer contador;
	
	@Column(name = "CALIFICACION")
	private Integer calificacion;
	
	@Column(name = "VISITAS")
	private Integer visitas;
	
	@Size(max = 200)
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name = "IDTIPOVIDEO", referencedColumnName = "IDTIPOVIDEO")
	@ManyToOne
	private Tipovideo tipovideo;
	
	@OneToMany(mappedBy="video", fetch = FetchType.LAZY)	
	private List<Comentario> comentarios;
	
	public Video() {}
	
	public Video(Integer id) {
		this.idvideo = id;
	}
	
	public List<Comentario> getComentario(){
		return this.comentarios;
	}

	public Integer getIdvideo() {
		return idvideo;
	}

	public void setIdvideo(Integer idvideo) {
		this.idvideo = idvideo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getRutaimagen() {
		return rutaimagen;
	}

	public void setRutaimagen(String rutaimagen) {
		this.rutaimagen = rutaimagen;
	}

	public String getRutavideo() {
		return rutavideo;
	}

	public void setRutavideo(String rutavideo) {
		this.rutavideo = rutavideo;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Integer getVisitas() {
		return visitas;
	}

	public void setVisitas(Integer visitas) {
		this.visitas = visitas;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}