/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LlistarDirectoris
{
    // Lista el contenido de un fichero e indica cual el fichero y cual es directorio
    public static void InformacionDeFicherosYDirectorios()
    {
        File directorio = new File("C:\\Users\\MiSe�or\\Documents");
        if(directorio.isDirectory())
        {
            String[] listado = directorio.list();
            System.out.println("DIRECTORIOS:\t");
            for(int i = 0; i < listado.length; i++)
            {
                File examinar = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i]);
                if(examinar.isDirectory())
                {
                    System.out.println("DIRECTORIO:\t" + listado[i]);
                    File directorioNivel1 = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i]);
                    String[] listadoNivel1 = directorioNivel1.list();
                	for(int j = 0; j < listadoNivel1.length; j++)
                	{
                		File examinarNivel1 = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i] + "\\" + listadoNivel1[j]);
                		if(examinarNivel1.isDirectory()) 
                		{
                			System.out.println("\tDIRECTORIO:\t" + listadoNivel1[j]);
                			File directorioNivel2 = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i] + "\\" + listadoNivel1[j]);
                			String[] listadoNivel2 = directorioNivel2.list();
                			for(int k = 0; k < listadoNivel2.length; k++)
                			{
                				File examinarNivel2 = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i] + "\\" + listadoNivel1[j] + "\\" + listadoNivel2[k]);
                				if(examinarNivel2.isDirectory())
                					System.out.println("		DIRECTORIO:\t" + listadoNivel2[k]);
                				else 
                					System.out.println("		FICHERO:\t" + listadoNivel2[k]);
                			}
                		}
                		else 
                            System.out.println("	FICHERO:\t" + listadoNivel1[j]);	
                	}
                }
            }
            System.out.println("FICHEROS:\t");
            for(int i = 0; i < listado.length; i++)
            {
                File examinar = new File("C:\\Users\\MiSe�or\\Documents\\" + listado[i]);
            	 if(!examinar.isDirectory())
                     System.out.println("FICHERO:\t" + listado[i]);
            }
        }else
            System.out.println("La ruta "+directorio.getPath()+" no es un directorio");
    }
    
    public static void main(String[] args)
    {      
        System.out.println("\n\nLlistar directori i indicar si es tracta de fitxer o element:");
        InformacionDeFicherosYDirectorios();
     }
}