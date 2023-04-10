package musicCollection.dao;

//import jdbcDAO.dao.*;
//import jdbcDAO.dao.IDAOFactory;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    private DAOFactory() {
        registerDriver();
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static synchronized IDAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public ComposerDAO getComposerDAO() {
        return new ComposerJDBCDAO();
    }

    @Override
    public StyleDAO getStyleDAO() {
        return new StyleJDBCDAO;
    }

    @Override
    public CompositionDAO getCompositionDAO() {
        return null;
    }

    @Override
    public DiscInfoDAO getDiscInfoDAO() {
        return null;
    }

    @Override
    public DiscJDBCDAO getDiscDAO() {
        return null;
    }
}
