package com.hotel.alura.modelo;

import javax.persistence.*;

// Mapeamos la entidad Usuario
@Entity
@Table(name = "ubusuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// La responsabilidad pertenece a la base de datos
	private Long id;
	private String nombre;
	@Column(unique = true, nullable = false)				// Email único y no nulo
	private String email;
	private String password;

	public Usuario() {
	}

	public Usuario(String nombre, String email, String password) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
