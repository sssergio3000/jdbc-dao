package musicCollection.dao;

import musicCollection.entity.Composer;
import musicCollection.entity.Composition;
import musicCollection.entity.DiscInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompositionJDBCDAO extends AbstrJDBCDAO implements CompositionDAO {
   @Override
   public void create(Composition composition) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            int composerID = getComposerIDByName(composition.getComposer().getName());
            int styleID = getStyleIDByTitle(composition.getStyle().getTitle());


            // check if we have already the composer
            if (composerID == -1){
                ps = connection.prepareStatement("insert into composers (name) values ?");
                ps.setString(1, composition.getComposer().getName());
                ps.execute();
                ps =  connection.prepareStatement("select MAX(id) from composers ");
                ResultSet rs = ps.executeQuery();
                rs.next();
                composerID = rs.getInt(1);

            }

            // check if we have already the style
            if (styleID == -1){
                ps = connection.prepareStatement("insert into styles (title) values ?");
                ps.setString(1, composition.getStyle().getTitle());
                ps.execute();
                ps =  connection.prepareStatement("select MAX(id) from styles ");
                ResultSet rs = ps.executeQuery();
                rs.next();
                styleID = rs.getInt(1);

            }
            // check if we have already this composition by title and composer
            ps = connection.prepareStatement("select title, composer from compositions where title = ? and composer = ?");
            ps.setString(1,composition.getTitle());
            ps.setInt(2, composerID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String compsitionTitle = rs.getString(1);
                System.out.printf("Composition <"+compsitionTitle+ "> by "+ composition.getComposer().getName()+" is already in DB");
                return;
            }

            ps = connection.prepareStatement("insert into compositions (title, composer, style, length_sec) values (?,?,?,?)");
            ps.setString(1, composition.getTitle());
            ps.setInt(2, composerID);
            ps.setInt(3, styleID);
            ps.setInt(4, composition.getLength());

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
    public void deleteByTitleAndComposer(String titleParam, String composerParam) {

    }

    @Override
    public int getLengthById(int id) {
        return 0;
    }

    @Override
    public List<Composition> getAll() {
        List<Composition> composition = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT id, title, composer, style, length from compositions " +
                    "inner join composers where composer = composers.id inner join styles where style = styles.id");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                Composer composer = new Composer (getComposerIDByName(rs.getString(3)), rs.getString(3));
                String styleTitle = rs.getString(4);
                int length = rs.getInt(5);


                Composition composition = new Composition(id, title, );
                discinfos.add(discInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnectionClosed(connection);
        }
        return discinfos;
        return null;
    }
    private int getComposerIDByName(String nameParam) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select id from composers where name = ? ");
            preparedStatement.setString(1, nameParam);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                return rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    private int getStyleIDByTitle(String titleParam) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select id from styles where title = ? ");
            preparedStatement.setString(1, titleParam);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                return rs.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
