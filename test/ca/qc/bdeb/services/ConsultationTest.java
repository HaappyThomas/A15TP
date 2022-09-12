package ca.qc.bdeb.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;

import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

@DisplayName("Test case for class Consultation")
public class ConsultationTest {
	
	private Consultation consultation = new Consultation();
	
	private UtilisateurDAO utilisateurDao = new UtilisateurDAO();
	private TacheDAO tacheDao = new TacheDAO();
	private int uid1, uid2, uid3, uid4;
	private int tacheId1, tacheId2, tacheId3, tacheId4;
	private int uidNonExistant = 0;
	private int tacheIdNonExistant = 0;
	
	// ajouter test data
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
	 * ************** 1:to test method voirUtilisateur() ***********
	 * ************************************************************* 
	 */
	//// 1.1: test utilisateur existant
	@Order(1)
//	@Disabled
	@Test
	@DisplayName("test method voirUtilisateur() en cas de utilisateur existe")
	public void voirUtilisateurExistant() {
		// ajouter test data: utilisateur
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();

		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("1.1");
		System.out.println(consultation.voirUtilisateur(uid1));
		System.out.println(consultation.voirUtilisateur(uid2));
		System.out.println(consultation.voirUtilisateur(uid3));
		System.out.println(consultation.voirUtilisateur(uid4));
		
		// assert
		assertEquals("Alain Flou", consultation.voirUtilisateur(uid1).getNomComplet());
		assertEquals("Annie Clair", consultation.voirUtilisateur(uid2).getNomComplet());
		assertEquals("Fannie Cossette", consultation.voirUtilisateur(uid3).getNomComplet());
		assertEquals("Luis Bessette", consultation.voirUtilisateur(uid4).getNomComplet());
	}
	
	
	//// 1.2: test utlisateur non-existant
	@Order(2)
//	@Disabled
	@Test
	@DisplayName("test method voirUtilisateur() en cas de utilisateur n'existe pas")
	public void voirUtilisateurNonExistant() {
		// afficher les utilisateurs non existants ajoutees pour plus facile a verifier manuellement
		System.out.println("1.2");
		System.out.println(consultation.voirUtilisateur(uidNonExistant));

		// assert
		assertEquals(null, consultation.voirUtilisateur(uidNonExistant).getNomComplet());
	}

	
	/* *****************************************************
	 * ******** 2: to test method voirTache() **************
	 * *****************************************************
	 */
	//// 2.1: test tache existant
	@Order(3)
//	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de tache existe")
	public void voirTacheExistant() {
		// ajouter des utilisateurs a l'avance parce que la tache a besoin de utilisateurId
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();
		// ajouter test data: tache
		tacheId1 = tacheDao.ajouter(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = tacheDao.ajouter(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = tacheDao.ajouter(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = tacheDao.ajouter(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();

		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("2.1");
		System.out.println(consultation.voirTache(tacheId1));
		System.out.println(consultation.voirTache(tacheId2));
		System.out.println(consultation.voirTache(tacheId3));
		System.out.println(consultation.voirTache(tacheId4));
		
		// assert 
		assertEquals("Java", consultation.voirTache(tacheId1).getDescription());
		assertEquals("Nodejs", consultation.voirTache(tacheId2).getDescription());
		assertEquals("C#", consultation.voirTache(tacheId3).getDescription());
		assertEquals("Angular", consultation.voirTache(tacheId4).getDescription());
	}
	
	//// 2.2: test tache non-existant
	@Order(4)
//	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de tache n'existe pas")
	public void voirTacheNonExistant() {
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		System.out.println("2.2");
		System.out.println(consultation.voirTache(tacheIdNonExistant));

		// assert 
		assertEquals(null,consultation.voirTache(tacheIdNonExistant).getDescription());
	}

	
	/* **********************************************
	 * ****** 3: to test method voirTaches() ********
	 * **********************************************
	 */
	//// 3.1: test utilisateur existant et il a des taches
	@Order(5)
//	@Disabled
	@Test
	@DisplayName("test method voirTaches() en cas de l'unilisateur existant et il a des taches")
	public void voirTachesEnCasDeUtilisateurExistantEtAyantTaches() {

		// ajouter test data: utilisateur
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();
		// ajouter test data: tache
		tacheId1 = tacheDao.ajouter(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = tacheDao.ajouter(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = tacheDao.ajouter(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = tacheDao.ajouter(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();
		
		// afficher les taches non existants ajoutees pour plus facile a verifier manullement
		System.out.println("3.1");
		System.out.println(consultation.voirTaches(uid1));
		System.out.println(consultation.voirTaches(uid2));
		
		// assert 
		assertEquals(2,consultation.voirTaches(uid1).size());
		assertEquals(2,consultation.voirTaches(uid2).size());

	}
	
	//// 3.2: test utilisateur existant et il n'a pas de taches
	@Order(6)
//	@Disabled
	@Test
	@DisplayName("test method voirTaches() en cas de l'unilisateur existant mais il n'a pas de tahce")
	public void voirTachesEnCasDeUtilisateurExistantEtNonTaches() {

		// ajouter test data: utilisateur
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();
		// ajouter test data: tache
		tacheId1 = tacheDao.ajouter(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = tacheDao.ajouter(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = tacheDao.ajouter(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = tacheDao.ajouter(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();
		
		// afficher les taches non existants ajoutees pour plus facile a verifier manullement
		System.out.println("3.2");
		System.out.println(consultation.voirTaches(uid3));
		System.out.println(consultation.voirTaches(uid4));;
		
		// assert 
		assertTrue(consultation.voirTaches(uid3).isEmpty());
	}
	
	//// 3.3: test utilisateur non-existant
	@Order(7)
//	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de utilisateur n'existe pas")
	public void voirTachesEnCasDeUtilisateurNonExistant() {
		
		// afficher les taches non existants ajoutees pour plus facile a verifier manullement
		System.out.println("3.3");
		System.out.println(consultation.voirTaches(uidNonExistant));
		// assert 
		assertTrue(consultation.voirTaches(uidNonExistant).isEmpty());
	}
	
	/* **********************************************
	 * ****** 4: to test method voirTousUtilisateur() ********
	 * **********************************************
	 */
	@Order(8)
//	@Disabled
	@Test
	@DisplayName("test method voirUtilisateur()")
	public void voirTousUtilisateur() {
		// ajouter test data: utilisateur
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();

		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurs = consultation.voirTousUtilisateur();
		System.out.println("8");
		System.out.println(utilisateurs);
		
		// assert
		assertEquals("Alain Flou", utilisateurs.get(0).getNomComplet());
		assertEquals("Annie Clair", utilisateurs.get(1).getNomComplet());
		assertEquals("Fannie Cossette", utilisateurs.get(2).getNomComplet());
		assertEquals("Luis Bessette", utilisateurs.get(3).getNomComplet());
	}
		
	/* **********************************************
	 * ****** 5: to test method voirTousTaches() ********
	 * **********************************************
	 */
	@Order(9)
//	@Disabled
	@Test
	@DisplayName("test method voirTousTaches()")
	public void voirTousTaches() {
		// ajouter test data: utilisateur
		uid1 = utilisateurDao.ajouter("Alain Flou").getUtilisateurId();
		uid2 = utilisateurDao.ajouter("Annie Clair").getUtilisateurId();
		uid3 = utilisateurDao.ajouter("Fannie Cossette").getUtilisateurId();
		uid4 = utilisateurDao.ajouter("Luis Bessette").getUtilisateurId();
		// ajouter test data: tache
		tacheId1 = tacheDao.ajouter(new Tache("Java", LocalDateTime.of(2022, 9, 11, 8, 30), 3, uid1)).getTacheId();
		tacheId2 = tacheDao.ajouter(new Tache("Nodejs", LocalDateTime.of(2022, 9, 11, 13, 00 ), 3, uid1)).getTacheId();
		tacheId3 = tacheDao.ajouter(new Tache("C#", LocalDateTime.of(2022, 9, 12, 8, 30), 3, uid2)).getTacheId();
		tacheId4 = tacheDao.ajouter(new Tache("Angular", LocalDateTime.of(2022, 9, 12, 13, 00), 3, uid2)).getTacheId();
		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		List<Tache> taches = new ArrayList<>();
		taches = consultation.voirTousTaches();
		System.out.println("9");
		System.out.println(taches);
		
		// assert
		assertEquals("Java", taches.get(0).getDescription());
		assertEquals("Nodejs", taches.get(1).getDescription());
		assertEquals("C#", taches.get(2).getDescription());
		assertEquals("Angular", taches.get(3).getDescription());
	}
	
	
	
	
}
