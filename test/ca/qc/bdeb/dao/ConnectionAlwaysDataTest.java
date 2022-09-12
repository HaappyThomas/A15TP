package ca.qc.bdeb.dao;

import static org.junit.Assert.assertEquals;

import java.sql.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

public class ConnectionAlwaysDataTest {

	private	Connection connection = ConnectionAlwaysData.getInstance();

	private UtilisateurDAO utilisateurDao = new UtilisateurDAO();
	private TacheDAO tacheDao = new TacheDAO();

	private int uid1, uid2, uid3, uid4;
	private int tacheId1, tacheId2, tacheId3, tacheId4;
	
	// ajouter test data
	@BeforeEach
	void setUp() {
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
	}
	
	// supprimer test data
	@AfterEach
	void tearDown() {
		// delete test data
		utilisateurDao.supprimerTousUtilisateurs();
	}
	
	@Test
	public void connectTableUtilisateurTest() {

		// afficher les utilisateurs ajoutees pour plus facile a verifier manuellement
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from TbL_Utilisateur");
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(rs.getString(2));
				System.out.println(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// assert 
		assertEquals("Alain Flou", utilisateurDao.trouver(uid1).getNomComplet());
		assertEquals("Annie Clair", utilisateurDao.trouver(uid2).getNomComplet());
		assertEquals("Fannie Cossette", utilisateurDao.trouver(uid3).getNomComplet());
		assertEquals("Luis Bessette", utilisateurDao.trouver(uid4).getNomComplet());
	}

	@Test
	public void connectTableTacheTest() {

		// afficher les taches ajoutees pour plus facile a verifier manullement
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("select * from TbL_Tache");
			while (rs.next()) {
				Tache tache = new Tache();
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				// changer SQL datetime au LocalDateTime
				Date timestamp = rs.getTimestamp(3);
				LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				System.out.println("localDateTime: " + localDateTime);
				tache.setDatetime(localDateTime);
				tache.setUtilisateurId(rs.getInt(4));
				System.out.println(tache);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// assert 
		assertEquals("Java", tacheDao.trouver(tacheId1).getDescription());
		assertEquals("Nodejs", tacheDao.trouver(tacheId2).getDescription());
		assertEquals("C#", tacheDao.trouver(tacheId3).getDescription());
		assertEquals("Angular", tacheDao.trouver(tacheId4).getDescription());
	}
}
