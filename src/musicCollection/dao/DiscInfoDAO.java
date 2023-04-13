package musicCollection.dao;

import musicCollection.entity.DiscInfo;


import java.util.List;

public interface DiscInfoDAO {

    void create(String titelParam);
    void deleteById(int id);
    List<DiscInfo> getAll();
}
