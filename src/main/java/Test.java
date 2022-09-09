import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


import ca.qc.bdeb.dao.IUtilisateurDAO;
import ca.qc.bdeb.dao.TacheDAO;
import ca.qc.bdeb.dao.UtilisateurDAO;
import ca.qc.bdeb.models.Tache;

public class Test {

	
	///Just pour tester

	public static void main(String[] args) throws SQLException {
		//IUtilisateurDAO u = new UtilisateurDAO ();
		//System.out.println("user"+u.trouverTachesDuUtilisateur(4));
	    LocalDate d = LocalDate.of(2022, 9, 01); 
		Tache t1 = new Tache("Deploiment",d,4,4);
		Tache t2 = new Tache("Dev",d,4,4);
		Tache t3 = new Tache("iNSTALLALTION",d,4,4);
		Tache t4= new Tache("Dev1",d,4,4);
		Tache t5 = new Tache("Dev2",d,4,4);
		Tache t6 = new Tache("Dv3",d,4,4);
		Tache t7 = new Tache("Dev4",d,4,4);
		//;
		//System.out.println("Lydia");
	// DateTime d = Date.now();
		TacheDAO t = new TacheDAO();
		t.ajouter(t7);
		t.ajouter(t6);
		t.ajouter(t5);
		t.ajouter(t4);
		t.ajouter(t3);
		t.ajouter(t2);
		t.ajouter(t1);
		
		
		t.supprimer(4);
		//System.out.println("tache"+t.trouver(2));
		//System.out.println("tache"+t.trouver(2));
		//System.out.println("Liste Taches"+t.trouverTachesDuUtilisateur(4));
	}

}
