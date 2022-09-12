package ca.qc.bdeb.models;

import java.time.*;

public class Tache {
	private int tacheId;
	private String description;
	private LocalDateTime datetime;
	private int duree;
	private int utilisateurId;
	
	public Tache() {
	}
	
	public Tache(String description, LocalDateTime datetime, int duree, int utilisateurId) {
		this.description = description;
		this.datetime = datetime;
		this.duree = duree;
		this.utilisateurId = utilisateurId;
	}


	public Tache(int tacheId, String description, LocalDateTime datetime, int duree, int utilisateurId) {
		this.tacheId = tacheId;
		this.description = description;
		this.datetime = datetime;
		this.duree = duree;
		this.utilisateurId = utilisateurId;
	}

	public int getTacheId() {
		return tacheId;
	}

	public void setTacheId(int tacheId) {
		this.tacheId = tacheId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	@Override
	public String toString() {
		return "Tache [tacheId=" + tacheId + ", description=" + description + ", datetime=" + datetime + ", duree="
				+ duree + ", utilisateurId=" + utilisateurId + "]" + "\n";
	}
	
	
	
	
}
