package musicCollection.dao;

import musicCollection.entity.Composer;

import java.util.List;

public interface ComposerDAO {
        void create(Composer composer);
        void deleteByName(String nameParam);
        Composer readByName (String nameParam);

        List<Composer> getAll();





}
