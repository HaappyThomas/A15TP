package ca.qc.bdeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.models.Utilisateur;

public class UtilisateurDAO implements IUtilisateurDAO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// Connexion a la BDD
	Connection con = ConnectionAlwaysData.getInstance();

	///// Une méthode pour retourner un utilisateur après son ajout dans la base de
	///// données (le nom complet est un paramètre de cette méthode)
	@Override
	public Utilisateur ajouter(String nomComplet) {

		Utilisateur utilisateur = new Utilisateur();
		try {
			ps = con.prepareStatement(ISQLConstant.INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nomComplet);

			int nbr = ps.executeUpdate();
			// recuperer utilisateurId generé automatiquement par DB
			rs = ps.getGeneratedKeys();
			if (nbr > 0) {
				System.out.println("L'utilisateur a été inseré");
				// positionner rs cursor à premere ligne
				rs.next();
				// set utilisateurId
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(nomComplet);

			} else {
				System.out.println("Operation echouée");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}

	// Une méthode pour retourner un utilisateur de la base de données
	// (l’identifiant est un paramètre de cette méthode)
	@Override
	public Utilisateur trouver(int id) {

		Utilisateur	utilisateur = new Utilisateur();
		try {
			ps = con.prepareStatement(ISQLConstant.RETOURNER_UTILISATEUR_ById);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;
	}

}
