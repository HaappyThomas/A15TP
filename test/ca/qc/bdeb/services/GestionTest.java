package ca.qc.bdeb.services;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

import ca.qc.bdeb.dao.ConnectionAlwaysData;
import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;

public class GestionTest {
	
	private	Connection connection = ConnectionAlwaysData.getInstance();
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
	@Order(1)
	@Disabled
	@Test
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
	@Order(2)
	@Disabled
	@Test
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
	@Order(3)
	@Disabled
	@Test
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
	
	
	
	
	
}
