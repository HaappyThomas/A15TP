package ca.qc.bdeb.dao;

public class ISQLConstant {
	
	//Les requetes SQL 
  
	static final String INSERT_UTILISATEUR = "INSERT INTO TbL_Utilisateur (NomComplet) VALUES (?)";
	static final String RETOURNER_UTILISATEUR_ById = "SELECT * FROM  TbL_Utilisateur where UtilisateurID like ? ";
	static final String INSERT_TACHE = "INSERT INTO TbL_Tache (Description, DateCreation, Duree, UtilisateurId) VALUES (?,?,?,?)";
	static final String RETOURNER_TACHE_ById = "SELECT * FROM TbL_Tache WHERE TacheID like ? ";
	static final String SELECT_TACHES_UTILISATEUR = "SELECT * FROM TbL_Utilisateur JOIN TbL_Tache ON TbL_Utilisateur.UtilisateurID = TbL_Tache.UtilisateurID WHERE TbL_Utilisateur.UtilisateurID like ?";
    static final String DELETE_TACHE = "DELETE  FROM TbL_Tache WHERE TacheID like ?";
}
