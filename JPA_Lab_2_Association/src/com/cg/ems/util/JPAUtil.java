package com.cg.ems.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//here entity manager used for connection
public class JPAUtil 
{
 private static EntityManagerFactory emf=null;
 private static EntityManager em=null;
 
 public static EntityManager getEntityManager() {
	 emf=Persistence.createEntityManagerFactory("Oracle-JPA-PU");
	 em=emf.createEntityManager();
	 return em;
 }
}
