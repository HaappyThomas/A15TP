package ca.qc.bdeb.dao;

public class ISQLConstant {
	
	//Les requetes SQL 
    //Select 
	static final String RETOURNER_CLIENT_ByNom = "SELECT * FROM  TbL_Utilisateur where NomComplet like ? ";
	
	//Une méthode pour retourner un utilisateur de la base de données 
		//(l’identifiant est un paramètre de cette méthode)
	static final String RETOURNER_CLIENT_ById = "SELECT * FROM  TbL_Utilisateur where UtilisateurID like ? ";

}
