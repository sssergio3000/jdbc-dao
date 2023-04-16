package musicCollection.dao;

import musicCollection.entity.Composer;
import musicCollection.entity.Composition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscJDBCDAO extends AbstrJDBCDAO implements DiscDAO {
    @Override
    public void writeToDisc(List<Composition> compositionsParam, String discName) {

//        List<Composition> discCompositions = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        int discID = getIdByDiscTitle(discName);



        try {
            if(discID == -1){
            preparedStatement = connection.prepareStatement("insert into disc_info (title) values ?");
            preparedStatement.setString(1, discName);

            }
            preparedStatement = connection.prepareStatement("insert into disc_tracks (disc_id, track_id) values (?,?) ");
            for (Composition composition : compositionsParam) {
                preparedStatement.setInt(1, discID);
                preparedStatement.setInt(2, (int)composition.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int totalDiscLength(int id) {
        return 0;
    }

    @Override
    public void deleteDiscById(int id) {

    }



    private int getIdByDiscTitle(String titleParam){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("select id from disc_info where title = ? ");
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

    List<Composition> getAllFromDisc(int idParam){
        List<Composition> compositions = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT track_id from disc_tracks where disc_id = ? ");
            preparedStatement.setInt(1, idParam);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int trackid = rs.getInt(1);

                compositions.add(trackid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnectionClosed(connection);
        }
        return composers;


    }
}
