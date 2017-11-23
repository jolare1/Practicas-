import java.sql.*;

import com.sun.swing.internal.plaf.basic.resources.basic_fr;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class AccesoDatosPt3 {

  Connection con;
	Statement st;
	ResultSet rs;
    
  public static void main(String[] args) {
    	AccesoDatosPt3 bd = new AccesoDatosPt3();
    	bd.abrirConexion();
      bd.getDatabaseMetaData();
      bd.getDatabaseTableData();
      bd.cerrarConexion();
    }
 
	public void abrirConexion() {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/basedas";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Conexión a la BD");
		} catch (Exception e) {
			System.out.println("Error en conexión ");
		}
	}
	
	// Para cerrar la conexión una vez terminadas las consultas
	public void cerrarConexion() {
		try {
			con.close();
			System.out.println("Conexión cerrada");
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
	}
  public void getDatabaseMetaData() {
      dbmd = con.getMetaData();
      String productName = dbmd.getDatabaseProductName();
      String driverName = dbmd.getDriverName();
      String url = dbmd.getURL();
      String userName = dbmd.getUserName();
      System.out.println("META INFORMACIÓ DE LA BASE DE DADES: NOM: " + productName + "DRIVER: " + driverName + "URL: " + url + "USUARI: " + userName);
  }
     
  public void getDatabaseTableData() {
      rs = dbmd.getTables(null, "basedas", null, null);
      String catalegName = rs.getString(catàleg);
      String esquemaName = rs.getString(esquema);
      String taulaName = rs.getString(taula);
      String tipus = rs.getString(tipus);
      System.out.println("TABLE - cataleg: " + catalegName + "esquema: " + esquemaName +  "taula: " + taulaName + tipus);
      /*while (rs.next()) {
         String catalegName = rs.getString(catàleg);
         String esquemaName = rs.getString(esquema);
         String taulaName = rs.getString(taula);
         String tipus = rs.getString(tipus);
         System.out.println("TABLE - cataleg: " + catalegName + "esquema: " + esquemaName +  "taula: " + taulaName + tipus);
      }*/
   }
}