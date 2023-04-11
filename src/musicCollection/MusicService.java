package musicCollection;


import musicCollection.dao.ComposerDAO;
import musicCollection.dao.IDAOFactory;
import musicCollection.dao.*;
import musicCollection.entity.Composer;
import musicCollection.entity.Style;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class MusicService {
    private IDAOFactory factory;
    private ComposerDAO composerDAO;
    private DiscInfoDAO discInfoDAO ;
    private DiscDAO discDAO;
    private StyleDAO styleDAO;

    private CompositionDAO compositionDAO;




    public MusicService() {
        factory = DAOFactory.getInstance();
        composerDAO = factory.getComposerDAO();
        compositionDAO = factory.getCompositionDAO();
        discDAO = factory.getDiscDAO();
        discInfoDAO = factory.getDiscInfoDAO();
        styleDAO = factory.getStyleDAO();


    }

    public void createNewComposer(Composer composerParam) {

        System.out.println("All composers BEFORE insert:");
        printAllComposers();

             composerDAO.create(composerParam);


        // A car with non-existing in db make


        System.out.println("\n All composers After insert:");
        printAllComposers();
    }

    public void deleteComposerByName(String name){
        System.out.println("All composers BEFORE delete: ");
        printAllComposers();

        composerDAO.deleteByName(name);

        System.out.println("\n All composers After delete:");
        printAllComposers();
    }
//
//
    public void readComposerByName (String nameParam) {
        Composer composer = composerDAO.readByName(nameParam);
        if (composer != null){
            System.out.println(composer);
        }
        else {
            System.out.println("No such composer in DB");
        }

    }

    public void createStyle (String title){

    }

//
//
//
//
//
//
    public void printAllComposers (){
        List<Composer> composers = composerDAO.getAll();
        Collections.sort(composers, comparing(Composer::getName));
        for(Composer composer : composers) {
            System.out.println(composer);
        }
    }

    public void printAllStyles (){
        List<Style> styles = styleDAO.getAll();
        Collections.sort(styles, comparing(Style::getTitle));
        for (Style style : styles) {
            System.out.println(style);
        }
    }





}




