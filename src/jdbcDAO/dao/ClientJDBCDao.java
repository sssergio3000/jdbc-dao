package jdbcDAO.dao;

import jdbcDAO.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao extends AbstractJdbcDao implements ClientDAO {

    @Override
    public void create(Client client) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("insert into clients (name, age, phone) values" +
                    "(?,?,?) ");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            disposeResources(connection, preparedStatement);
        }


    }

    @Override
    public void deleteByID(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from clients where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            disposeResources(connection, preparedStatement);
        }


    }

    @Override
    public Client read(int id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        List <Client> allClients = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from clients");

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);
                allClients.add(new Client (id, name, age, phone));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            getConnectionClosed(connection);
        }




        return allClients;
    }

    @Override
    public void updatePhone(int id, String phone) {

    }
}
