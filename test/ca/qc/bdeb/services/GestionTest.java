package ca.qc.bdeb.services;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;

public class GestionTest {
	
	private Gestion gestion = new Gestion();
	
	private UtilisateurDAO utilisateurDao = new UtilisateurDAO();
	private TacheDAO tacheDao = new TacheDAO();
	
	private int uid1, uid2, uid3, uid4;
	private int tacheId1, tacheId2, tacheId3, tacheId4;
	
	@BeforeEach
	void setUp() {
	}
	
	// supprimer test data
	@AfterEach
	void tearDown() {
		// delete test data
		utilisateurDao.supprimerTousUtilisateurs();
	}
	

	/*
	 * *************************************************************
	 * ************** 1:to test method ajouterUtilisateur() ***********
	 * ************************************************************* 
	 */
	//// 
	@Test
	@Order(1)
	@Disabled
	@DisplayName("test method ajouterUtilisateur()")
	public void ajouterUtilisateur() {
		
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();
		uid2 = gestion.ajouterUtilisateur("Annie Clair").getUtilisateurId();
		uid3 = gestion.ajouterUtilisateur("Fannie Cossette").getUtilisateurId();
		uid4 = gestion.ajouterUtilisateur("Luis Bessette").getUtilisateurId();
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("1");
		System.out.println(utilisateurDao.trouver(uid1));
		System.out.println(utilisateurDao.trouver(uid2));
		System.out.println(utilisateurDao.trouver(uid3));
		System.out.println(utilisateurDao.trouver(uid4));
		
		// todo 比较预期结果和真实的返回结果
		// assert
		assertEquals("Alain Flou", utilisateurDao.trouver(uid1).getNomComplet());
		assertEquals("Annie Clair", utilisateurDao.trouver(uid2).getNomComplet());
		assertEquals("Fannie Cossette", utilisateurDao.trouver(uid3).getNomComplet());
		assertEquals("Luis Bessette", utilisateurDao.trouver(uid4).getNomComplet());
	}
	
	/*
	 * *************************************************************
	 * ************** 2:to test method ajouterTache() ***********
	 * ************************************************************* 
	 */
	//// 
	@Test
	@Order(2)
	@Disabled
	@DisplayName("test method ajouterTache()")
	public void ajouterTache() {

		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();
		uid2 = gestion.ajouterUtilisateur("Annie Clair").getUtilisateurId();
		uid3 = gestion.ajouterUtilisateur("Fannie Cossette").getUtilisateurId();
		uid4 = gestion.ajouterUtilisateur("Luis Bessette").getUtilisateurId();
		
		// ajouter les taches
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = gestion.ajouterTache(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = gestion.ajouterTache(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("2");
		System.out.println(tacheDao.trouver(tacheId1));
		System.out.println(tacheDao.trouver(tacheId2));
		System.out.println(tacheDao.trouver(tacheId3));
		System.out.println(tacheDao.trouver(tacheId4));
		
		// assert
		assertEquals("Java", tacheDao.trouver(tacheId1).getDescription());
		assertEquals("Nodejs", tacheDao.trouver(tacheId2).getDescription());
		assertEquals("C#", tacheDao.trouver(tacheId3).getDescription());
		assertEquals("Angular", tacheDao.trouver(tacheId4).getDescription());
	}
	
	/*
	 * *************************************************************
	 * ************** 3:to test method supprimerTache() ***********
	 * ************************************************************* 
	 */
	//// 
	@Test
	@Order(3)
	@Disabled
	@DisplayName("test method supprimerTache()")
	public void supprimerTache() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();
		uid2 = gestion.ajouterUtilisateur("Annie Clair").getUtilisateurId();
		uid3 = gestion.ajouterUtilisateur("Fannie Cossette").getUtilisateurId();
		uid4 = gestion.ajouterUtilisateur("Luis Bessette").getUtilisateurId();
		
		// ajouter les taches
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = gestion.ajouterTache(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = gestion.ajouterTache(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();
		
		// supprimer tache
		Tache tacheSupprime = gestion.supprimerTache(tacheId1);
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("3");
		System.out.println("tacheId1->tache supprime: " + tacheSupprime);
		System.out.println("chercher tacheId1: " + tacheDao.trouver(tacheId1));
		
		// assert
		assertEquals("Java", tacheSupprime.getDescription());
		assertEquals(null, tacheDao.trouver(tacheId1).getDescription());
	}
	
	/*
	 * *************************************************************
	 * ************** 4:to test method ajouterTacheV2() ***********
	 * ************************************************************* 
	 */
	@Test
	@Order(4)
	@Disabled
	@DisplayName("test method ajouterTacheV2 sans taches existantes")
	public void ajouterTacheV2SansTachesExistantes() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches
		String resultat = gestion.ajouterTacheV2(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.1");
		System.out.println(resultat);
		
		// assert
		assertEquals("La tache a été inseré", resultat);
	}
	
	@Test
	@Order(5)
	@Disabled
	@DisplayName("test method ajouterTacheV2 sans tache conflit avec des valeurs limites")
	public void ajouterTacheV2SansTachesConflit() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:00-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 00), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 11:00-13:00 avec value limites
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 11, 00), 2, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.2");
		System.out.println(resultat);
		
		// assert
		assertEquals("La tache a été inseré", resultat);
	}	
	
	@Test
	@Order(6)
	@Disabled
	@DisplayName("test method ajouterTacheV2 sans tache conflit avec des valeurs frontalieres")
	public void ajouterTacheV2SansTachesConflitValeurFrontaliere() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:00-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 00), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 11:01-12:01 avec value limites
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 11, 01), 1, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.3");
		System.out.println(resultat);
		
		// assert
		assertEquals("La tache a été inseré", resultat);
	}	
	
	
	@Test
	@Order(7)
	@Disabled
	@DisplayName("test method ajouterTacheV2 en tache conflit avec valeur d'une cote")
	public void ajouterTacheV2AvecTachesConflitValeurUneCote() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:30-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 10:40-11:40
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 10, 40), 1, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.4");
		System.out.println(resultat);
		
		// assert
		assertEquals("L'horaire d'une tache existante", resultat);
	}		

	@Test
	@Order(8)
	@Disabled
	@DisplayName("test method ajouterTacheV2 en tache conflit avec valeur de l'une cote")
	public void ajouterTacheV2AvecTachesConflitValeurAutreCote() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:30-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 11:40-13:40
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 11, 40), 2, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.5");
		System.out.println(resultat);
		
		// assert
		assertEquals("L'horaire d'une tache existante", resultat);
	}		
	
	@Test
	@Order(9)
	@Disabled
	@DisplayName("test method ajouterTacheV2 en tache conflit avec valeur frontaliere une cote")
	public void ajouterTacheV2AvecTachesConflitValeurFrontaliereUneCote() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:30-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 10, 59 ), 1, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 11:40-13:40
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 11, 40), 2, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.6");
		System.out.println(resultat);
		
		// assert
		assertEquals("L'horaire d'une tache existante", resultat);
	}	
	
	@Test
	@Order(10)
	@Disabled
	@DisplayName("test method ajouterTacheV2 en tache conflit avec valeur frontaliere l'autre cote")
	public void ajouterTacheV2AvecTachesConflitValeurFrontaliereAutreCote() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter les taches deja existent: tache Java 8:30-11:30 et Nodejs 13:00-16:00
		tacheId1 = gestion.ajouterTache(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = gestion.ajouterTache(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 10, 59 ), 1, uid1)).getTacheId();

		// ajouter la nouvelle tache: Hibernate 2022-09-11 11:01-13:01
		String resultat = gestion.ajouterTacheV2(new Tache("Hebernate", LocalDateTime.of(2022, 9, 11, 11, 01), 2, uid1));
		
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("4.7");
		System.out.println(resultat);
		
		// assert
		assertEquals("L'horaire d'une tache existante", resultat);
	}	
	
	/*
	 * *************************************************************
	 * ************** 5:to test method ajouterTacheV3() ***********
	 * ************************************************************* 
	 */
	@Test
	@Order(11)
	@Disabled
	@DisplayName("test method ajouterTacheV2 en tache conflit avec valeur frontaliere l'autre cote")
	public void ajouterTacheV3SansConflit() {
		// ajouter les utilisateur a l'avance parce que les taches ont besoin utilisateurId
		uid1 = gestion.ajouterUtilisateur("Alain Flou").getUtilisateurId();

		// ajouter la nouvelle tache: Heure de conduire 2022-4-25 15:00-16:00
		String resultat = gestion.ajouterTacheV3(new Tache("Hebernate", LocalDateTime.of(2022, 4, 25, 15, 00), 1, uid1), 4);
		
		List<Tache> taches = new Consultation().voirTaches(uid1);
		LocalDateTime localDateTime = LocalDateTime.of(2022, 04, 25, 15, 00);

		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("5.1");
		System.out.println(resultat);
		System.out.println(taches);
		
		// assert
		assertEquals("Toutes les taches sont été inserées", resultat);

		assertEquals(localDateTime, taches.get(0).getDatetime());
		assertEquals(localDateTime.plusDays(7), taches.get(1).getDatetime());
		assertEquals(localDateTime.plusDays(14), taches.get(2).getDatetime());
		assertEquals(localDateTime.plusDays(21), taches.get(3).getDatetime());
	}
	
}
