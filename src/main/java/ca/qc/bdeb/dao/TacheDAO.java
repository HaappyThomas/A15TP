package ca.qc.bdeb.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

public class TacheDAO implements ITacheDAO {
<<<<<<< HEAD

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// Connexion a la BDD
	Connection con = ConnectionAlwaysData.getInstance();

	// Une méthode pour retourner une tâche après son ajout dans la base de données
	// (les données d’une tâche sont des paramètres de cette méthode)
	@Override
	public Tache ajouter(Tache tache) {
		try {
			ps = con.prepareStatement(ISQLConstant.INSERT_TACHE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tache.getDescription());
			ps.setObject(2, tache.getDatetime());
			ps.setInt(3, tache.getDuree());
			ps.setInt(4, tache.getUtilisateurId());
			int nbr = ps.executeUpdate();
			// recuperer tacheId generé automatiquement dans DB
			rs = ps.getGeneratedKeys();
			if (nbr > 0) {
				// positionner cursor à premiere ligne
				rs.next();
				// set tacheId pour tache
				tache.setTacheId(rs.getInt(1));
				System.out.println("La tache a été inseré");
			} else {
				System.out.println("Operation echouée");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
	
	private Tache tache;
    private PreparedStatement ps = null;
    
    
    //Connexion a la BDD
    ConnectionAlwaysData connection = new ConnectionAlwaysData();
	Connection con = connection.getInstance();
	
	//Une méthode pour retourner une tâche après son ajout dans la base de données
	//(les données d’une tâche sont des paramètres de cette méthode) 
	@Override
	public Tache ajouter(Tache tache) throws SQLException {
		
		
		ps = con.prepareStatement(ISQLConstant.INSERT_TACHE);
		ps.setString(1, tache.getDescription());
		ps.setString(2, tache.getDatetime().toString());
		ps.setInt(3, tache.getDuree());
		ps.setInt(4, tache.getUtilisateurId());
>>>>>>> d4c1006eaea72f29f874b03c97642f8c3e22484a

		return tache;
	}

	// Une méthode pour retourner une tâche (l’identifiant est un paramètre de cette
	// méthode)
	@Override
	public Tache trouver(Integer idTache) {
		Tache tache = new Tache();
		try {
			ps = con.prepareStatement(ISQLConstant.RETOURNER_TACHE_ById);
			ps.setInt(1, idTache);

			rs = ps.executeQuery();
			if (rs.next()) {
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));

				//changer SQL datetime au LocalDateTime
//				Date timestamp = rs.getTimestamp(3);
//				LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				tache.setDatetime(localDateTime);
				tache.setDatetime(rs.getTimestamp(3).toLocalDateTime());

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

				// changer SQL datetime au LocalDateTime
//				Date timestamp = rs.getTimestamp(3);
//				LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				tache.setDatetime(localDateTime);
				tache.setDatetime(rs.getTimestamp(3).toLocalDateTime());
				
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
		Tache tache = new Tache();
		try {
			ps = con.prepareStatement(ISQLConstant.DELETE_TACHE);
			ps.setInt(1, idTache);
			
			// recuperer tache à supprimer par idTache
			ResultSet rs = ps.executeQuery("SELECT * FROM TbL_Tache WHERE TacheID = " + idTache);
			if (rs.next()) {
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				
				// changer SQL datetime au LocalDateTime
//				Date timestamp = rs.getTimestamp(3);
//				LocalDateTime localDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//				tache.setDatetime(localDateTime);
				tache.setDatetime(rs.getTimestamp(3).toLocalDateTime());
				
				tache.setDuree(rs.getInt(4));
				tache.setUtilisateurId(rs.getInt(5));

				ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tache;
	}
	
	// delete all taches
	public int supprimerTousTaches() {
		int rows = 0;
		try {
			ps = con.prepareStatement(ISQLConstant.DELETE_ALL_TACHE);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	
	// find all tahces
	public List<Tache> findAll(){
		List<Tache> taches = new ArrayList<>();
		try {
			ps = con.prepareStatement(ISQLConstant.FIND_ALL_TACHE);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tache tache = new Tache();
				tache.setTacheId(rs.getInt(1));
				tache.setDescription(rs.getString(2));
				tache.setDatetime(rs.getTimestamp(3).toLocalDateTime());
				tache.setDuree(rs.getInt(4));
				tache.setUtilisateurId(rs.getInt(5));
				taches.add(tache);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taches; 
	}

}
