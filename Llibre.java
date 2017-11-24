import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Llibre {

	int numPag;
	String titol;
	float preu;

	public Llibre(int numPag, String titol, float preu) {
		super();
		this.numPag = numPag;
		this.titol = titol;
		this.preu = preu;
	}


	public static void main(String[] args) {
		Map<Integer, Llibre> map = new HashMap<Integer, Llibre>();	
		map.put(0, new Llibre(345, "Moby Dick", 14.95f));
		map.put(1, new Llibre(50, "50 ombres de Gray", 39.95f));
		map.put(2, new Llibre(574, "Els viatges de Gulliver", 4.90f));
		map.put(3, new Llibre(255, "Els androides somien xais elèctrics?",  9.95f));
		map.put(4, new Llibre(200, "Pórtico",6f));
		Listar(map);
		ListarMesDeuEuros(map);
	}
	
	public static void Listar(Map<Integer, Llibre> map) {
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  Integer key = (Integer) it.next();
			System.out.println("Titol " + key + ": " + map.get(key).titol);
		}
	}
	public static void ListarMesDeuEuros(Map<Integer, Llibre> map) {
			
			map.values().stream().filter(llibre -> llibre.preu > 10).forEach((s) -> System.out.println(s.titol));
	}
	

}
