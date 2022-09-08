package ca.qc.bdeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.qc.bdeb.models.Utilisateur;



public class UtilisateurDAO implements IUtilisateurDAO {
	private Utilisateur utilisateur;
    private PreparedStatement ps = null;
    
    
    //Connexion a la BDD
    ConnectionAlwaysData connection = new ConnectionAlwaysData();
	Connection con = connection.getInstance();
	
    
    /////Une méthode pour retourner un utilisateur après son ajout dans la base de données (le nom complet est un paramètre de cette méthode)
	@Override
	public Utilisateur ajouter(String nomComplet) throws SQLException {

		ps = con.prepareStatement(ISQLConstant.INSERT_UTILISATEUR);
		ps.setString(1, nomComplet);

		int nbr = ps.executeUpdate();
		Utilisateur utilisateur = new Utilisateur();
		 if (nbr > 0) {
	            System.out.println("L'utilisateur a été inseré");
	            ResultSet rs = ps.executeQuery("SELECT * FROM TbL_Utilisateur WHERE NomComplet = "+nomComplet);
			    utilisateur = new Utilisateur();
				utilisateur.setUtilisateurId(rs.getInt(1));
				utilisateur.setNomComplet(rs.getString(2));
				
	        } else {
	            System.out.println("Operation echouée");
	        }
	        return utilisateur;
	}
 

	//Une méthode pour retourner un utilisateur de la base de données 
	//(l’identifiant est un paramètre de cette méthode)
	@Override
	public Utilisateur trouver(int id) throws SQLException {
		
		ps = con.prepareStatement(ISQLConstant.RETOURNER_UTILISATEUR_ById);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		Utilisateur utilisateur = new Utilisateur();
		if(rs.next()){
		utilisateur.setUtilisateurId(rs.getInt(1));
		utilisateur.setNomComplet(rs.getString(2));
		
		}
	

		return utilisateur;
	}
	
	
	
	
	

}
