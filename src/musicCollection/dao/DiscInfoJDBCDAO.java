package musicCollection.dao;




import musicCollection.entity.DiscInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscInfoJDBCDAO extends AbstrJDBCDAO implements DiscInfoDAO{
    @Override
    public void create(String titelParam) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("select * from disc_info where title = ?");
            ps.setString(1,titelParam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                int id  = rs.getInt(1);
                System.out.printf("This disc "+ name +" exists already in DB");
                return;
            }

            ps = connection.prepareStatement("insert into disc_info (title) values (?)");
            ps.setString(1, titelParam);
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
    public void deleteById(int id) {
        Connection connection = getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("delete  from disc_info where id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();

                        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        finally {
            if (connection != null) {
                getConnectionClosed(connection);
            }
        }


    }

    @Override
    public List<DiscInfo> getAll() {


            List<DiscInfo> discinfos = new ArrayList<>();
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement("SELECT * from disc_info ");

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);

                    DiscInfo discInfo = new DiscInfo(id, name);
                    discinfos.add(discInfo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                getConnectionClosed(connection);
            }
            return discinfos;


        }
    }

