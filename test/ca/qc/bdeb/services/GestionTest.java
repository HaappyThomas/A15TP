package ca.qc.bdeb.services;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

import ca.qc.bdeb.models.Tache;

public class GestionTest {
	
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
	 * ************** 1:to test method ajouterUtilisateur() ***********
	 * ************************************************************* 
	 */
	//// 
	@Order(1)
	@Disabled
	@Test
	@DisplayName("test method ajouterUtilisateur()")
	public void ajouterUtilisateur() {
		String nomComplet = "Vincent Cossette";
		
		System.out.println("1");
		System.out.println(new Gestion().ajouterUtilisateur(nomComplet));
		
		// todo 比较预期结果和真实的返回结果
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
		LocalDate date = LocalDate.of(2022, 9, 20);
		Tache tache = new Tache("Node", date, 4, 4);
		
		System.out.println("2");
		System.out.println(new Gestion().ajouterTache(tache));
		
		// todo 比较预期结果和真实的返回结果
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
		int tacheId = 14;
		
		System.out.println("3");
		System.out.println(new Gestion().supprimerTache(tacheId));
		
		// todo 比较预期结果和真实的返回结果
	}
	
	
	
	
	
}
