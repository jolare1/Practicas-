import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class AgendaContactes extends AbstractList<Contacte>{

	static List<Contacte> contactes = new ArrayList<>();
	
	
	public static void main(String[] args) {
		contactes.add(new Contacte("Joan", "Lajarin", "Reinares", 20, 608939457, "jolare1@insgabrielamistral.cat"));
		contactes.add(new Contacte("Xavi", "Prats", "Santiso", 19, 625720250, "xprasan1@insgabrielamistral.cat"));
		contactes.add(new Contacte("Enrique", "Lajarin", "Encina", 56, 60000000, "enrique@insgabrielamistral.cat"));
		//for(int index = 0; index < 2; index++) {
		//	System.out.println(contactes.get(index).nom);
		//}
		Contacte.compareTo(contactes);
	}

	@Override
	public Contacte get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
