package ca.qc.bdeb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

public class ConnectionAlwaysDataTest {
	
	@Test
	public void connectTableUtilisateurTest() {
		Connection connection = ConnectionAlwaysData.getInstance();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from TbL_Utilisateur");
//			List<Utilisateur> utilisateurs = new ArrayList<>();
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(rs.getString(2));
//				utilisateurs.add(utilisateur);
				System.out.println(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
