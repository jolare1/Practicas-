import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacte implements Comparable<Contacte>  {

	public Contacte(String nom, String primerCognom, String segonCognom, int edat, int telefon, String email) {
		super();
		this.nom = nom;
		this.primerCognom = primerCognom;
		this.segonCognom = segonCognom;
		this.edat = edat;
		this.telefon = telefon;
		this.email = email;
	}

	String nom;
	String primerCognom;
	String segonCognom;
	int edat;
	int telefon;
	String email;

	@Override
	public int compareTo(Contacte compareContact) {
		return 0;
	}
	public static int compareTo(List<Contacte> contactes) {
		
		List<Integer> AgendaContactes = new ArrayList<>();

		for (Contacte element : contactes) {
			AgendaContactes.add(element.edat);
		}
		AgendaContactes.sort(null);
		System.out.println(AgendaContactes);
		return 0;
	}
}
