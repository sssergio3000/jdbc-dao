package musicCollection.dao;

public class ComposerJDBCDAO extends AbstrJDBCDAO implements ComposerDAO{

    private static final String URL = "jdbc:mysql://localhost:3306/music_library";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
}
