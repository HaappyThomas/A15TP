import java.sql.SQLException;

import ca.qc.bdeb.dao.IUtilisateurDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;

public class Test {

	public static void main(String[] args) throws SQLException {
		IUtilisateurDAO u = new UtilisateurDAO ();
		//u.ajouter("Alain Flou");
		u.trouver(1);
	}

}
