package com.example.proyectos.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO")
	private Integer idusuario;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Size(max = 255)
	@Column(name = "IMAGEN")
	private String imagen;
	
	@Size(max = 40)
	@NotEmpty
	@Email
	@Column(name = "EMAIL")
	private String email;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="FECHANACIMIENTO")	
	private Date fechanacimiento;

	@Size(max = 15)
	@Column(name = "ROL")
	private String rol;
	
	@Size(max = 25)
	@Column(name = "PASSWORD")
	private String password;
	
	@Size(max = 200)
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@OneToMany(mappedBy= "usuario",fetch=FetchType.LAZY)	
	private List<Video> videos;
	
	@OneToMany(mappedBy= "usuario",fetch=FetchType.LAZY)	
	private List<Comentario> comentarios;
	
	public Usuario() {
		videos = new ArrayList<Video>();
	}
	
	public Usuario(Integer id) {
		videos = new ArrayList<Video>();
		this.idusuario = id;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void addVideo(Video video) {
		videos.add(video);
	}
	
	public List<Video> getVideos() {
		return this.videos;
	}
}