package musicCollection.dao;

import musicCollection.entity.Composer;
import musicCollection.entity.Style;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StyleJDBCDAO extends AbstrJDBCDAO implements StyleDAO {
    @Override
    public void creat(String style) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("select * from styles where title = ?");
            ps.setString(1, style);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                int id = rs.getInt(1);
                System.out.printf("Style " + name + " is already in Styles list with id: " + id);
                return;
            }

            ps = connection.prepareStatement("insert into styles (title) values (?)");
            ps.setString(1, style);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                getConnectionClosed(connection);
            }
        }
    }

        @Override
        public void delete(String styleParam){
            Connection connection = getConnection();
            PreparedStatement ps = null;

            try {
                ps = connection.prepareStatement("delete from styles  where title = (?)");
                ps.setString(1, styleParam);
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    getConnectionClosed(connection);
                }
            }
        }

    @Override
    public List<Style> getAll() {
        List<Style> styles = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * from styles ");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);

                Style style = new Style(id, title);
                styles.add(style);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnectionClosed(connection);
        }
        return styles;


    }
}
