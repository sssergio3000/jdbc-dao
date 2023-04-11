package musicCollection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstrJDBCDAO {


    private static final String URL = "jdbc:mysql://localhost:3306/musiccollection";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";


    protected Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    protected void getConnectionClosed (Connection connection){
        if (connection != null){
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
