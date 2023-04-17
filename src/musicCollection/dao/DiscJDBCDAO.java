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
    public void writeToDisc(List<Integer> compositionsIDParam, String discName) {

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        int discID = getIdByDiscTitle(discName);


        try {
            if (discID == -1) {
                preparedStatement = connection.prepareStatement("insert into disc_info (title) values (?)");
                preparedStatement.setString(1, discName);
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement("select MAX(id) from disc_info");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    discID = rs.getInt(1);
                }

            }
            preparedStatement = connection.prepareStatement("insert into disc_tracks (disc_id, track_id) values (?,?) ");
            for (Integer compositionID : compositionsIDParam) {
                preparedStatement.setInt(1, discID);
                preparedStatement.setInt(2, (int) compositionID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int totalDiscLength(int idParam) {

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        int totalLength = 0;

        try {
            preparedStatement = connection.prepareStatement("select SUM(length_sec) from compositions cmp inner join disc_tracks dt on cmp.id = dt.track_id where dt.disc_id = (?)");
            preparedStatement.setInt(1, idParam);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalLength = rs.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalLength;
    }

    @Override
    public void deleteDiscById(int idParam) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from disc_info where id = (?)");
            preparedStatement.setInt(1,idParam);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private int getIdByDiscTitle(String titleParam) {
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

    List<Integer> getAllFromDisc(int idParam) {
        List<Integer> compositionsID = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT track_id from disc_tracks where disc_id = ? ");
            preparedStatement.setInt(1, idParam);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int trackid = rs.getInt(1);

                compositionsID.add(trackid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnectionClosed(connection);
        }
        return compositionsID;


    }
}
