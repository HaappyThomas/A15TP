package ca.qc.bdeb.dao;

import java.sql.SQLException;
import java.util.List;

import ca.qc.bdeb.models.Tache;

public interface ITacheDAO {
	
	/**
	 * ajouter une tache
	 * @param tache
	 * @return tache ajoute
	 * @throws SQLException 
	 */
	public Tache ajouter(Tache tache) throws SQLException;
	
	/**
	 * chercher une tache par idTache
	 * @param idTache
	 * @return tache trouve
	 * @throws SQLException 
	 */
	public Tache trouver(Integer idTache) throws SQLException;
	
	/**
	 * chercher toutes les taches d'un utilisateur par idUtilisateur
	 * @param idUtilisateur
	 * @return liste des taches
	 */
	public List<Tache> trouverTachesDuUtilisateur(Integer idUtilisateur);
	
	/**
	 * supprimer une tache par idTache
	 * @param idTache
	 * @return tache supprime
	 */
	public Tache supprimer(Integer idTache);
	
	}
