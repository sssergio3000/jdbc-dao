package musicCollection.dao;

import musicCollection.entity.Composer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            ps.executeUpdate();
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
    public void renameByNmae(String nameParam, String newNameParam) {

    }
}
