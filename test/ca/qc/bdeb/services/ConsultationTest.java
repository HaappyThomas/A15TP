package ca.qc.bdeb.services;

import org.junit.Test;
import org.junit.jupiter.api.*;

@DisplayName("Test case for class Consultation")
public class ConsultationTest {
	
	// todo 标准做法 加入测试数据，测试结束删除数据，保证数据库中没有残留数据
	
	@BeforeEach
	void setUp() {
		// todo: ajouter test data
	}
	
	@AfterEach
	void tearDown() {
		// todo: delete test data
	}
	
	
	/*  
	 * *************************************************************
	 * ************** 1:to test method voirUtilisateur() ***********
	 * ************************************************************* 
	 */
	//// 1.1: test utilisateur existant
	@Order(1)
	@Disabled
	@Test
	@DisplayName("test method voirUtilisateur() en cas de utilisateur existe")
	public void voirUtilisateurExistant() {
		System.out.println("1.1");
		System.out.println(new Consultation().voirUtilisateur(3));
		
		// todo 比较预期结果和真实的返回结果
	}
	
	//// 1.2: test utlisateur non-existant
	@Order(2)
	@Disabled
	@Test
	@DisplayName("test method voirUtilisateur() en cas de utilisateur n'existe pas")
	public void voirUtilisateurNonExistant() {
		System.out.println("1.2");
		System.out.println(new Consultation().voirUtilisateur(0));
	}

	
	/* *****************************************************
	 * ******** 2: to test method voirTache() **************
	 * *****************************************************
	 */
	//// 2.1: test tache existant
	@Order(3)
	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de tache existe")
	public void voirTacheExistant() {

		System.out.println("2.1");
		System.out.println(new Consultation().voirTache(5));
		
		// todo 比较预期结果和真实的返回结果
	}
	
	//// 2.2: test tache non-existant
	@Order(4)
	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de tache n'existe pas")
	public void voirTacheNonExistant() {
		System.out.println("2.2");
		System.out.println(new Consultation().voirTache(0));
	}

	
	/* **********************************************
	 * ****** 3: to test method voirTaches() ********
	 * **********************************************
	 */
	//// 3.1: test utilisateur existant et il a des taches
	@Order(5)
	@Disabled("true")
	@Test
	@DisplayName("test method voirTaches() en cas de l'unilisateur existant")
	public void voirTachesEnCasDeUtilisateurExistantEtAyantTaches() {

		System.out.println("3.1");
		System.out.println(new Consultation().voirTaches(4));
		
		// todo 比较预期结果和真实的返回结果
	}
	
	//// 3.2: test utilisateur existant et il n'a pas de taches
	@Order(6)
	@Disabled
	@Test
	@DisplayName("test method voirTaches() en cas de l'unilisateur existant")
	public void voirTachesEnCasDeUtilisateurExistantEtNonTaches() {

		System.out.println("3.2");
		System.out.println(new Consultation().voirTaches(5));
		
		// todo 比较预期结果和真实的返回结果
	}
	
	//// 3.3: test utilisateur non-existant
	@Order(7)
	@Disabled
	@Test
	@DisplayName("test method voirTache() en cas de utilisateur n'existe pas")
	public void voirTachesEnCasDeUtilisateurNonExistant() {
		
		System.out.println("3.3");
		System.out.println(new Consultation().voirTaches(0));
	}
}
