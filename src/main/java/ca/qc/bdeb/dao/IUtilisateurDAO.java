package ca.qc.bdeb.dao;

import java.sql.SQLException;

import ca.qc.bdeb.models.Utilisateur;

public interface IUtilisateurDAO {
	
	
	/**
	 * ajouter un utilisateur
	 * @param nomComplet
	 * @return utilisateur ajoute
	 * @throws SQLException 
	 */
	public Utilisateur ajouter(String nomComplet) throws SQLException;

	/**
	 * chercher un utilisateur par id
	 * @param id
	 * @return utilisateur trouve
	 * @throws SQLException 
	 */
	public Utilisateur trouver(int id) throws SQLException;
	
}
