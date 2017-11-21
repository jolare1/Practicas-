import java.sql.*;

import com.sun.swing.internal.plaf.basic.resources.basic_fr;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class AccesoDatos {
    public static void main(String[] args) {
    	AccesoDatos bd = new AccesoDatos();
    	bd.abrirConexion();
    	bd.obtenerDatosTabla();
    	//bd.mostrarDatos();
    	//bd.modificarDatos();
    	//bd.insertarDatos();
    	//bd.borrar();
    	bd.insertarProjectos(11);//li pasem el codi del client del qual farem el projecte
    	bd.borrarClient(0);//li pasarem el codi del client , la funció ens borrara el client i els seus projectes
    	bd.cerrarConexion();  	
    }
	Connection con;
	Statement st;
	ResultSet rs;
	int clienteExiste = 0;

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
	
	public void obtenerDatosTabla() {
		try {
		 st =con.createStatement();
		 rs = st.executeQuery("SELECT * FROM empleats");
		 System.out.println("Tabla abierta");
		} catch (SQLException e) {
		 System.out.println("Error al Abrir tabla ");
		}
	}
	public void mostrarDatos() {
			try {
			 while (rs.next()) {
			 String strCodiempl = rs.getString("codi_empl");
			 String strNomempl = rs.getString("nom_empl");
			 String strCognomempl = rs.getString("cognom_empl");
			 int numSou = rs.getInt("sou");
			 String strNom_dpt = rs.getString("nom_dpt");
			 String strCiutat_dpt = rs.getString("ciutat_dpt");
			 int numProj = rs.getInt("num_proj");
			 System.out.println(strCodiempl + ", " + strNomempl + ", " + strCognomempl  + ", " + numSou + ", " + strNom_dpt + ", " + strCiutat_dpt + ", " + numProj);
			 	}
			} catch (Exception e) {
			 System.out.println("Error al visualizar datos");
			}
	}
	
	public void modificarDatos()
	{
		try {
			st = con.createStatement();
			st.executeUpdate("Update empleats set sou=0 where ciutat_dpt='BARCELONA'");
			System.out.println("Elemento modificado correctamente");
		}catch (SQLException e)
		{
		 System.out.println("Error al modificar");
		}
	}  
	
	public void insertarDatos()
	{ 
		try {
			st = con.createStatement();
			st.executeUpdate("INSERT INTO empleats (codi_empl, nom_empl, cognom_empl, sou, nom_dpt, ciutat_dpt) values (9, 'JOAN','LAJARIN', 666, 'DIS', 'BARCELONA')");
			System.out.println("Elemento insertado");
		}
		catch(SQLException e)
		{
			System.out.println("Error al insertar ");
		}
	}
	
	public void borrar() {
		try {
			st = con.createStatement();
			st.executeUpdate("DELETE FROM empleats where codi_empl=9");
			System.out.println("Elemento Borrado");
		} catch (SQLException e) {
			System.out.println("Error al Borrar");
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
	
	public void validarCodiClient(int codi_client) {
		try {
			 st =con.createStatement();
			 rs = st.executeQuery("SELECT * FROM clients WHERE codi_cli=" + codi_client);
			 String codi_Cli = "";
			 while (rs.next()) {
			 codi_Cli = rs.getString("codi_cli");
			 System.out.println(codi_Cli);
			 }
			 
			 if (codi_Cli == "") {
				 clienteExiste = 0;
			 }	
			 else {
				 clienteExiste = 1;
			 }
		}
		catch(SQLException e) {
			
		}
	}
	public void insertarProjectos(int codi_client)
	{ 
		try {
			validarCodiClient(codi_client);
			if(clienteExiste == 1) {
				st = con.createStatement();
				st.executeUpdate("INSERT INTO projectes (codi_proj, nom_proj, preu, data_inici, data_prev_fi, data_fi, codi_client ) values (6, 'JEfJE', 666, '1997-11-11', '1997-11-11', '1997-11-11', " + codi_client + ")");
				System.out.println("Elemento insertado");
			}
			else if (clienteExiste == 0) {
				System.out.println("No existe el cliente");
			}
			else {
				System.out.println("Error");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error al insertar ");
		}
	}
	public void borrarClient(int codi_client) {
		try {
			st = con.createStatement();
			st.executeUpdate("DELETE FROM projectes where codi_client=" + codi_client);
			st.executeUpdate("DELETE FROM clients where codi_cli=" + codi_client);
			System.out.println("Elemento Borrado");
		} catch (SQLException e) {
			System.out.println("Error al Borrar");
		}
	}
}