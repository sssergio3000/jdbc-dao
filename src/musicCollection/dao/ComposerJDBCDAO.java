package musicCollection.dao;

import jdbcDAO.entity.Car;
import musicCollection.entity.Composer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComposerJDBCDAO extends AbstrJDBCDAO implements ComposerDAO{
    @Override
    public void create(Composer composer) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("select * from composers where name = ?");
            ps.setString(1,composer.getName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                int id  = rs.getInt(1);
                System.out.printf("Composer "+ name +" is already in Composer list with id: " +id);
                return;
            }

            ps = connection.prepareStatement("insert into composers (name) values ?");
            ps.setString(1, composer.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                getConnectionClosed(connection);
            }
        }





    }

    @Override
    public void deleteByName(String nameParam) {

    }

    @Override
    public Composer readByName(String nameParam) {
        return null;
    }

    @Override
    public void renameByName(String nameParam, String newNameParam) {

    }

    @Override
    public List<Composer> getAll(){
        List<Composer> composers = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * from composers ");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                Composer composer = new Composer(id, name);
                composers.add(composer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnectionClosed(connection);
        }
        return composers;


    };
}
