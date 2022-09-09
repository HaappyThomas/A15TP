package ca.qc.bdeb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

public class ConnectionAlwaysDataTest {

	// todo 标准做法 加入测试数据，测试结束删除数据，保证数据库中没有残留数据
	
	@BeforeEach
	void setUp() {
		// todo: ajouter test data
	}
	
	@AfterEach
	void tearDown() {
		// todo: delete test data
	}
	
	@Test
	public void connectTableUtilisateurTest() {
		Connection connection = ConnectionAlwaysData.getInstance();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from TbL_Utilisateur");
//			List<Utilisateur> utilisateurs = new ArrayList<>();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(rs.getString(2));
//				utilisateurs.add(utilisateur);
				System.out.println(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// todo 比较预期结果和真实的返回结果
	}

	@Test
	public void connectTableTacheTest() {
		Connection connection = ConnectionAlwaysData.getInstance();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select * from TbL_Tache");
//			List<Tache> taches = new ArrayList<>();

			while (rs.next()) {
				Tache tache = new Tache();
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				tache.setDatetime(rs.getDate(3).toLocalDate());
				tache.setUtilisateurId(rs.getInt(4));
				
//				taches.add(tache);
				System.out.println(tache);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// todo 比较预期结果和真实的返回结果
	}
}
