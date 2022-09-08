import java.sql.SQLException;

import ca.qc.bdeb.dao.IUtilisateurDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;

public class Test {

	
	///Just pour tester
	public static void main(String[] args) throws SQLException {
		IUtilisateurDAO u = new UtilisateurDAO ();
		System.out.println("user"+u.ajouter("luisa"));
		
		System.out.println("user"+u.trouver(4));
		//;
		System.out.println("Lydia");
	}

}
