package ca.qc.bdeb.services;

import java.time.LocalTime;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;
import ca.qc.bdeb.models.Utilisateur;


@Path("/gestion")
public class Gestion {
	
	@POST
	@Path("/ajouter/utilisateur/{nomComplet}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur ajouterUtilisateur(@PathParam("nomComplet") String nomComplet) {
		
		return new UtilisateurDAO().ajouter(nomComplet);
	}
	
	
	@POST
	@Path("/ajouter/tache")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Tache ajouterTache(Tache tache) {

		return new TacheDAO().ajouter(tache);
	}
	
	@DELETE
	@Path("/supprimer/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache supprimerTache(@PathParam("id") Integer id) {
		
		return new TacheDAO().supprimer(id); 
	}
	
	
	@POST
	@Path("/tache/v2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String ajouterTacheV2(Tache tache) {
		String resultat = "La tache a été inseré";
		TacheDAO tacheDao = new TacheDAO();
		LocalTime tacheLocalTimeBegin = tache.getDatetime().toLocalTime();
		LocalTime tacheLocalTimeEnd = tache.getDatetime().toLocalTime().plusHours(tache.getDuree());

		LocalTime itemLocalTimeBegin;
		LocalTime itemLocalTimeEnd;
		
		// trouver toutes les taches de cet utilisateur
		List<Tache> tachesExistantes = tacheDao.trouverTachesDuUtilisateur(tache.getUtilisateurId());
		// verifier si l'on peut ajouter la nouvelle tache 
		if(!tachesExistantes.isEmpty()) {
			for(Tache item: tachesExistantes){
				itemLocalTimeBegin= item.getDatetime().toLocalTime();
				itemLocalTimeEnd = item.getDatetime().toLocalTime().plusHours(item.getDuree());
				
				// afficher pour debug
				System.out.println("tacheLocalTimeBegin: " + tacheLocalTimeBegin);
				System.out.println("tacheLocalTimeEnd: " + tacheLocalTimeEnd);
				System.out.println("itemLocalTimeBegin: " + itemLocalTimeBegin);
				System.out.println("itemLocalTimeEnd: " + itemLocalTimeEnd);
				
				if(tacheLocalTimeBegin.isBefore(itemLocalTimeEnd)
						&& tacheLocalTimeEnd.isAfter(itemLocalTimeBegin)) {
					resultat = "L'horaire d'une tache existante";
					return resultat;
				}
			}
			tacheDao.ajouter(tache);
		}else {
			tacheDao.ajouter(tache);
		}

		return resultat;
	}
	
	@POST
	@Path("/tache/v3/{nbRepetition}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String ajouterTacheV3(Tache tache, @PathParam("nbRepetition") Integer nbRepetition) {
//		String resultat = "Attention! Operation non executee";
		String resultat = "Toutes les taches sont été inserées";
		TacheDAO tacheDao = new TacheDAO();
		int step = 0;
		
		// on ajouter les taches sans verifier
		for(int i = 0; i < nbRepetition; i++) {
			tache.setDatetime(tache.getDatetime().plusDays(step));
			tacheDao.ajouter(tache);
			step = 7;
		}
		
		return resultat;
	}
}
