package I3.DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.sqlite.*;



/**
 *
 * @author Faysal Ahmed
 */


public class DataBaseConnection {

    // The one and only instance
    private static DataBaseConnection instance = null;

    // The one and only connection
    private Connection connection = null;

    // Private constructor — nobody outside can call new DataBaseConnection()
    private DataBaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:hotel.sqlite");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DB Connection Failed: " + ex.toString());
        }
    }

    // The only way to get the instance
    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    // Get the connection from the instance
    public Connection getConnection() {
        return connection;
    }
}
