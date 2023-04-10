package musicCollection.dao;

import musicCollection.entity.Composer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComposerJDBCDAO extends AbstrJDBCDAO implements ComposerDAO{
    @Override
    public void create(Composer composer) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("insert into composers (name) values ?");
            ps.setString(1, composer.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
