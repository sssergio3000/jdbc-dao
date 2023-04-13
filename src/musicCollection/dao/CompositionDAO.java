package musicCollection.dao;

import musicCollection.entity.Composer;
import musicCollection.entity.Composition;

import java.util.List;

public interface CompositionDAO {

    void create(Composition composition);
    void deleteByTitleAndComposer(String titleParam, String composerParam);
    int getLengthById (int id);

    List<Composition> getAll();
}
