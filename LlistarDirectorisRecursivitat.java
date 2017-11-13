/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LlistarDirectorisRecursivitat
{
    // Lista el contenido de un fichero e indica cual el fichero y cual es directorio
	 public static void InformacionDeFicherosYDirectorios(File directorio)
	    {
	        if(directorio.isDirectory())
	        {
	            String[] listado = directorio.list();
	        
	            for(int i = 0; i < listado.length; i++)
	            {
	                File examinar = new File(directorio + "\\" + listado[i]);
	                if(examinar.isDirectory()) {
	                    System.out.println("DIRECTORIO:\t" + listado[i]);
	                    InformacionDeFicherosYDirectorios(examinar);
	                }    
	                else
	                    System.out.println("FICHERO:\t" + listado[i]);
	            }
	        }else
	            System.out.println("La ruta "+directorio.getPath()+" no es un directorio");
	    }
    
    public static void main(String[] args)
    {      
        System.out.println("\n\nLlistar directori i indicar si es tracta de fitxer o element:");
        File directorio = new File("C:\\Users\\MiSeñor\\Documents");
        int level = 0;
        InformacionDeFicherosYDirectorios(directorio);
    }
}