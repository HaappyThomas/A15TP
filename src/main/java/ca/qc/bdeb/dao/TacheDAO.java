package ca.qc.bdeb.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

public class TacheDAO implements ITacheDAO {

	private Tache tache;
	private PreparedStatement ps = null;

	// Connexion a la BDD
//	ConnectionAlwaysData connection = new ConnectionAlwaysData();
	Connection con = ConnectionAlwaysData.getInstance();

	// Une méthode pour retourner une tâche après son ajout dans la base de données
	// (les données d’une tâche sont des paramètres de cette méthode)

	@Override
	public Tache ajouter(Tache tache) {
		try {
			ps = con.prepareStatement(ISQLConstant.INSERT_TACHE);
			ps.setString(1, tache.getDescription());
			// ps.set(2, tache.getDatetime());
			ps.setInt(3, tache.getDuree());
			ps.setInt(4, tache.getUtilisateurId());

			int nbr = ps.executeUpdate();
			tache = new Tache();
			if (nbr > 0) {
				System.out.println("La tache a été inseré");

			} else {
				System.out.println("Operation echouée");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tache;
	}

	// Une méthode pour retourner une tâche (l’identifiant est un paramètre de cette
	// méthode)
	@Override
//	public Tache trouver(Integer idTache) throws SQLException {
	public Tache trouver(Integer idTache) {
		try {
			ps = con.prepareStatement(ISQLConstant.RETOURNER_TACHE_ById);
			ps.setInt(1, idTache);

			ResultSet rs = ps.executeQuery();
			tache = new Tache();
			if (rs.next()) {
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				tache.setDatetime(rs.getDate(3).toLocalDate());
				tache.setDuree(rs.getInt(4));
				tache.setUtilisateurId(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tache;

	}

	// Une méthode pour retourner toutes les tâches d’un utilisateur donnée
	// (l’identifiant de l’utilisateur est un
	// paramètre de cette méthode) Une méthode pour retourner une tâche après sa
	// suppression de la
	@Override
	public List<Tache> trouverTachesDuUtilisateur(Integer idUtilisateur) {
		List<Tache> listing = new ArrayList();
		try {
			ps = con.prepareStatement(ISQLConstant.SELECT_TACHES_UTILISATEUR);
			ps.setInt(1, idUtilisateur);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tache tache = new Tache();
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				tache.setDatetime(rs.getDate(3).toLocalDate());
				tache.setDuree(rs.getInt(4));
				tache.setUtilisateurId(rs.getInt(5));

				listing.add(tache);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listing;
	}

	// Une méthode pour retourner une tâche après sa suppression de la base de
	// données (l’identifiant est un paramètre de cette méthode)
	@Override
	public Tache supprimer(Integer idTache) {
		try {
			ps = con.prepareStatement(ISQLConstant.DELETE_TACHE);
			ps.setInt(1, idTache);
			ResultSet rs = ps.executeQuery("SELECT * FROM TbL_Tache WHERE TacheID = " + idTache);
			if (rs.next()) {
				Tache tache = new Tache();
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				tache.setDatetime(rs.getDate(3).toLocalDate());
				tache.setDuree(rs.getInt(4));
				tache.setUtilisateurId(rs.getInt(5));

				int nbr = ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tache;
	}

}
