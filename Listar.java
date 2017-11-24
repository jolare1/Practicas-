import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Listar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaSenseIterador();
		ListaAmbIterador();
	}
	public static void  ListaSenseIterador() {
		List<Float> listFloats = new ArrayList<>();
		listFloats.add(5.6f);
		listFloats.add(2.0f);
		listFloats.add(12.9f);
		
		for (Float element : listFloats) {
			System.out.println(element);
		}
	}
	public static void  ListaAmbIterador() {
		List<Float> listFloats = new ArrayList<>();
		listFloats.add(5.6f);
		listFloats.add(2.0f);
		listFloats.add(12.9f);
		
		Iterator<Float> iterator = listFloats.listIterator();
		while (iterator.hasNext()) {
		   System.out.println(iterator.next());
		}

	}
}
