package dev;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dev.entites.heritage.Particulier;

public class AppGenerate {

	public static void main(String[] args) {

		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
//		
//		Personne p1 = new Personne();
//		p1.setNom("Nom 1");
//		p1.setPrenom("Prenom 1");
//		
//		Adresse adresse = new Adresse();
//		adresse.setRue("Rue 1");
//		adresse.setVille("Ville 1");
//		
//		p1.setAdresse(adresse);
//		
//		em.persist(p1);
//	
//
		
		Particulier p1 = new Particulier();
		p1.setAdresse("super rue");
		p1.setTelephone("super phone");
		p1.setNom("super nom");
		p1.setPrenom("super prenom");
		
		em.persist(p1);
		
		tx.commit();

		em.close();

		emf.close();

	}

}
