package ca.qc.bdeb.dao;

import ca.qc.bdeb.models.Utilisateur;

public interface IUtilisateurDAO {
	
	/**
	 * ajouter un utilisateur
	 * @param nomComplet
	 * @return utilisateur ajoute
	 */
	public Utilisateur ajouter(String nomComplet);

	/**
	 * chercher un utilisateur par id
	 * @param id
	 * @return utilisateur trouve
	 */
	public Utilisateur trouver(int id);
	
}
