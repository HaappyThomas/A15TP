package ca.qc.bdeb.dao;

public class ISQLConstant {
	
	//Les requetes SQL 
  
	static final String INSERT_UTILISATEUR = "INSERT INTO TbL_Utilisateur (NomComplet) VALUES (?)";
	static final String RETOURNER_UTILISATEUR_ById = "SELECT * FROM  TbL_Utilisateur where UtilisateurID like ? ";
	static final String INSERT_TACHE = "INSERT INTO TbL_Tache (Description, DateCreation, Duree, UtilisateurId) VALUES (?,?,?,?)";
	static final String RETOURNER_TACHE_ById = "SELECT * FROM TbL_Tache WHERE TacheID like ? ";
	static final String SELECT_TACHES_UTILISATEUR = "SELECT tache.TacheID, tache.Description, tache.DateCreation, tache.Duree, tache.UtilisateurID "
													+ "FROM TbL_Utilisateur JOIN TbL_Tache tache ON TbL_Utilisateur.UtilisateurID = tache.UtilisateurID "
													+ "WHERE TbL_Utilisateur.UtilisateurID = ?";
    static final String DELETE_TACHE = "DELETE  FROM TbL_Tache WHERE TacheID like ?";
    static final String DELETE_ALL_TACHE = "DELETE  FROM TbL_Tache WHERE TacheID > 0";
    static final String DELETE_ALL_UTILISATEUR = "DELETE  FROM TbL_Utilisateur WHERE UtilisateurID > 0";
}
