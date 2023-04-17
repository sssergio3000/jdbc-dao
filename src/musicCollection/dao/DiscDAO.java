package musicCollection.dao;

import musicCollection.entity.Composition;

import java.util.List;

public interface DiscDAO {

    void writeToDisc(List<Integer> compositionsID, String discName);

    int totalDiscLength (int id);

    void deleteDiscById(int id);



}
