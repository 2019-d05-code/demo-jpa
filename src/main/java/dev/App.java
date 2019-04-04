package dev;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	public static void main(String[] args) {

		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
		
		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx = em1.getTransaction();
		tx.begin();
		
		// création d'une requête
		TypedQuery<Livre> requete = em1.createQuery("select l from Livre l where l.titre=:t1", Livre.class);
		requete.setParameter("t1", "formation jdbc");
		
		List<Livre> listeLivres = requete.getResultList();
		
		listeLivres.forEach(unLivre -> {
			//unLivre.setAuteur("Rossi");
			System.out.println(unLivre.getId() + " - "  + unLivre.getTitre() + " - " + unLivre.getAuteur());
		});
		
		// insérer un nouveau livre
		Livre livre1 = new Livre();
		//livre1.setId(202);
		livre1.setAuteur("Rossi");
		livre1.setTitre("formation java");
		
		// uniquement insert SQL
		em1.persist(livre1);
		
		// update SQL si id existe sinon insert
		// em1.merge(livre1);
		
		tx.commit();
		
		// Fin d'une unité de travail
		em1.close();
		
		emf.close();
		
		
		
	}

}
