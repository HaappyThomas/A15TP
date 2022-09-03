package ca.qc.bdeb.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;

@Path("/voir")
public class Consultation {

	
	@GET
	@Path("/utilisateur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur voirUtilisateur(@PathParam("id") Integer id) {
		// todo
		
		return null;
	}
	
	
	@GET
	@Path("/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache voirTache(@PathParam("id") Integer id) {
		// todo
		
		return null;
	}
	
	@GET
	@Path("/taches/utilisateur/{idUtilisateur}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tache> voirTaches(@PathParam("idUtilisateur") Integer idUtilisateur) {
		List<Tache> taches = new ArrayList<>();
		
		return taches;
	}
	
}
