package ejemploconexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Clase que permite establecer la conexión
 *
 * @author Sara Chamseddine F.
 */
public class ConnectionManager {

    private static Connection CONEXION = null;

    private static Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (CONEXION != null) {
            System.out.println("Conexión exitosa.");
            return CONEXION;
        } else {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            CONEXION = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            System.out.println("Driver cargado.");
            return CONEXION;
        }
    }

    public void closeConnection() throws SQLException {
        if (CONEXION!=null) {
            CONEXION.close();
            CONEXION=null;
        }
    }

}
