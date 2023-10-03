package com.hotel.alura.dao;

import com.hotel.alura.modelo.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDao {
	
	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Usuario usuario) {
		this.em.persist(usuario);
	}

	// Metodo que guarda un usuario nuevo en la base de datos
	public void nuevoUsuario(String nombre, String email, String password) {
		
		Usuario usuario = new Usuario(nombre, email, password);
		em.getTransaction().begin();	// Abre transaccion
		this.em.persist(usuario);		// Guarda el usuario en la base de datos (persistencia)
		em.getTransaction().commit();	// Compromete transaccion (envia valor a la base de datos)
		em.close();						// Cierra la conexion
	}

	// Metodo que verifica las credenciales del usuario
	public boolean acceder(String email, String password) {
		
		String jpql = "SELECT u FROM usuario u WHERE u.email = :email";	// Creamos consulta JPQL
		em.getTransaction().begin();
		Usuario usuario = em.createQuery(jpql, Usuario.class).setParameter("email", email).getSingleResult();
		em.close();
		return usuario != null && usuario.getPassword().equals(password);
	}

	// Metodo que obtiene un usuario a partir de su email y contraseña
	public Usuario obtenerUsuario(String email, String password) {
		
		em.getTransaction().begin();
		String jpql = "SELECT u FROM usuario u WHERE u.email = :email";
		Usuario usuario = em.createQuery(jpql, Usuario.class).setParameter("email", email).getSingleResult();
		em.close();
		return usuario;
	}
}