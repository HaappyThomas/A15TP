package ca.qc.bdeb.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

@Path("/voir")
public class Consultation {

	/**
	 * find utilisateur by id
	 * chercher utilisateur par id
	 * @param id
	 * @return utilisateur or null
	 * @throws SQLException 
	 */
	@GET
	@Path("/utilisateur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur voirUtilisateur(@PathParam("id") Integer id) {
		
		return new UtilisateurDAO().trouver(id);
	}

	/**
	 * find all utilisateurs
	 * chercher tous les utlisateurs
	 * @return
	 */
	@GET
	@Path("/utilisateurs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> voirTousUtilisateur() {
		
		return new UtilisateurDAO().findAll();
	}
	
	/**
	 * find tache by id
	 * checher tache par id
	 * @param id
	 * @return tache or null
	 */
	@GET
	@Path("/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache voirTache(@PathParam("id") Integer id) {
		
		return new TacheDAO().trouver(id);
	}
	
	/**
	 * find all tache of an utilisateur by utilisateur id
	 * checher toutes les tache d'un utilisateur par utlisateur id
	 * @param idUtilisateur
	 * @return List<Tache> all taches of an utilisateur
	 */
	@GET
	@Path("/taches/utilisateur/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tache> voirTaches(@PathParam("idUtilisateur") Integer idUtilisateur) {
		
		return new TacheDAO().trouverTachesDuUtilisateur(idUtilisateur);
	}
	
	/**
	 * find all taches
	 * chercher toutes les taches
	 * @return
	 */
	@GET
	@Path("/taches")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tache> voirTousTaches() {
		
		return new TacheDAO().findAll();
	}

	
}
