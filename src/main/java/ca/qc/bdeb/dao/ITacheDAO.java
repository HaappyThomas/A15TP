package ca.qc.bdeb.dao;

import java.util.List;

import ca.qc.bdeb.models.Tache;

public interface ITacheDAO {
	
	/**
	 * ajouter une tache
	 * @param tache
	 * @return tache ajoute
	 */
	public Tache ajouter(Tache tache);
	
	/**
	 * chercher une tache par idTache
	 * @param idTache
	 * @return tache trouve
	 */
	public Tache trouver(Integer idTache);
	
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
