import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.javafx.scene.layout.region.Margins.Converter;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		codificarPractica1();
		//codificarPractica2();
	}

	public static void codificarPractica1() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			FileInputStream stream = new FileInputStream("C:\\Users\\Joan\\Documents\\LOL");
			byte[] data = new byte[1024];
			int Readbytes = 0;

			while (-1 != (Readbytes = stream.read(data))) {
				md.update(data, 0, Readbytes);
			}
			byte[] hash = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {

				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
			}
			//
			String sFichero = "C:\\Users\\Joan\\Documents\\LOL";
			File fichero = new File(sFichero);
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			String hex =  sb.toString();
			//bw.write ("Hex");
			FileWriter fw = new FileWriter(sFichero);
		    fw.write(hex);
			System.out.println("Hex fromat : " + sb.toString());
			stream.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	public static void codificarPractica2() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			FileInputStream stream = new FileInputStream("C:\\Users\\Joan\\Documents\\LOL.txt");
			byte[] data = new byte[1024];
			int Readbytes = 0;

			while (-1 != (Readbytes = stream.read(data))) {
				md.update(data, 0, Readbytes);
			}
			byte[] hash = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {

				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println("Hex fromat : " + sb.toString());
			stream.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	
}
