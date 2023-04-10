package musicCollection.dao;

public interface IDAOFactory {

    ComposerDAO getComposerDAO();
    StyleDAO getStyleDAO();

    CompositionDAO getCompositionDAO();

    DiscInfoDAO getDiscInfoDAO();

    DiscDAO getDiscDAO();





}
