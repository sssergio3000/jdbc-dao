package musicCollection.dao;

import musicCollection.entity.Style;

import java.util.List;

public interface StyleDAO {

    void creat(String style);

    void delete(String style);

    List<Style> getAll();


}
