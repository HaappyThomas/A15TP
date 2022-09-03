package ca.qc.bdeb.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;


@Path("/gestion")
public class Gestion {
	
	@POST
	@Path("/ajouter/utilisateur/{nomComplet}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur ajouterUtilisateur(@PathParam("nomComplet") String nomComplet) {
		// todo
		
		return null;
	}
	
	
	@POST
	@Path("/ajouter/tache")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tache ajouterTache(Tache tache) {
		// todo
		
		return null;
	}
	
	@DELETE
	@Path("/supprimer/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache supprimerTache(@PathParam("id") Integer id) {
		//todo
		
		return null;
	}
	
	
	@POST
	@Path("/tache/v2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String ajouterTacheV2(Tache tache) {
		String resultat = "L'horaire d'une tache existante";
		// todo
		
		return resultat;
	}
	
	@POST
	@Path("/tache/v3/{nbRepetition}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String ajouterTacheV3(Tache tache, @PathParam("nbRepetition") Integer nbRepetition) {
		String resultat = "Attention! Operation non executee";
		// todo
		
		
		return resultat;
	}
}
