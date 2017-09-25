package ejemploconexionmysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase es un ejemplo para conectar Java con MySQL.
 *
 * @author Sara Chamseddine.
 * @since 25/09/2017
 */
public class EjemploConexionMySQL {

    public static void main(String[] args) {

        String consulta = null;

        try {

            // 1. Cargar el driver.  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver cargado.");

            // 2. Establecer la conexion.
            Connection conexion = null;
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");

            if (conexion != null) {
                System.out.println("Conexión exitosa.");
            } else {
                System.out.println("evisar la URL de conexión, usuaio, contraseña.");
            }

            // 3. Ejecutar operación de selección (Productos que ha comprado cada cliente (CustomerNumber, CustomeName, ProductName)).
            consulta = "SELECT customers.customerNumber, customers.customerName, products.productName FROM customers,products,orders,orderdetails WHERE customers.customerNumber=orders.customerNumber AND orders.orderNumber=orderdetails.orderNumber AND orderdetails.productCode=products.productCode";
            Statement st = conexion.createStatement();
            // Si la consulta me retorna resultados.
            ResultSet rs = st.executeQuery(consulta);
            // Si la consulta es de insert, update o delete.
            //int RSI = st.executeUpdate(consulta);

            while (rs.next()) {
                System.out.println(rs.getString("customerName"));
            }

        } catch (InstantiationException ex) {
            System.out.println("Clase no encontrada.");
        } catch (IllegalAccessException ex) {
            System.out.println("No se puede crear la instancia.");
        } catch (ClassNotFoundException ex) {
            System.err.println("No tiene acceso al driver.");
        } catch (SQLException ex) {
            System.out.println("Conexión fallida.");
        }

    }

}
