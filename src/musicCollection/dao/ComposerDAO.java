package musicCollection.dao;

import musicCollection.entity.Composer;

public interface ComposerDAO {
        void create(Composer composer);
        void deleteByName(String nameParam);
        Composer readByName (String nameParam);

        void renameByNmae (String nameParam, String newNameParam);





}
