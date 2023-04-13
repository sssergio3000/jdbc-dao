package musicCollection.dao;

import musicCollection.entity.Composition;

import java.util.List;

public class CompositionJDBCDAO extends AbstrJDBCDAO implements CompositionDAO {
    @Override
    public void create(Composition composition) {

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
        return null;
    }
}
