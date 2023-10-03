package com.hotel.alura.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	// FACTORY nos permite crear el Entity Manager Factory
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotelalura");
	
	// getEntityManager nos permite crear el Entity Manager
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
