package musicCollection;


import musicCollection.dao.ComposerDAO;
import musicCollection.dao.IDAOFactory;
import musicCollection.dao.*;
import musicCollection.entity.Composer;
import musicCollection.entity.Composition;
import musicCollection.entity.DiscInfo;
import musicCollection.entity.Style;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class MusicService {
    private IDAOFactory factory;
    private ComposerDAO composerDAO;
    private DiscInfoDAO discInfoDAO;
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
//composer operations begin
    public void createNewComposer(Composer composerParam) {

        System.out.println("All composers BEFORE insert:");
        printAllComposers();

        composerDAO.create(composerParam);


        System.out.println("\n All composers After insert:");
        printAllComposers();
    }

    public void deleteComposerByName(String name) {
        System.out.println("All composers BEFORE delete: ");
        printAllComposers();

        composerDAO.deleteByName(name);

        System.out.println("\n All composers After delete:");
        printAllComposers();
    }

    //
//
    public void readComposerByName(String nameParam) {
        Composer composer = composerDAO.readByName(nameParam);
        if (composer != null) {
            System.out.println(composer);
        } else {
            System.out.println("No such composer in DB");
        }

    }
    public void printAllComposers() {
        List<Composer> composers = composerDAO.getAll();
        Collections.sort(composers, comparing(Composer::getName));
        for (Composer composer : composers) {
            System.out.println(composer);
        }
    }
    //composer operations end


    //style operations begin
    public void createStyle(String title) {
        System.out.println("Styles before adding: ");
        printAllStyles();

        styleDAO.creat(title);

        System.out.println("\nStyles after adding: ");
        printAllStyles();

    }

    public void deleteStyleByTitle (String titleParam){
        System.out.println("All styles BEFORE delete: ");
        printAllStyles();

        styleDAO.deleteByTitle(titleParam);

        System.out.println("\n All styles AFTER delete:");
        printAllStyles();
    }


    public void printAllStyles() {
        List<Style> styles = styleDAO.getAll();
        Collections.sort(styles, comparing(Style::getTitle));
        for (Style style : styles) {
            System.out.println(style);
        }
    }
//    style operations end
//    discInfo operations begin
public void createDiscInfo(String title) {
    System.out.println("DiscInfos before adding: ");
    printAllDiscInfo();

    discInfoDAO.create(title);

    System.out.println("DiscInfos after adding: ");
    printAllDiscInfo();

}

    public void deleteDiscInfoById (int idParam){
        System.out.println("DiscInfos before deleting: ");
        printAllDiscInfo();

        discInfoDAO.deleteById(idParam);

        System.out.println("DiscInfos after deleting: ");
        printAllDiscInfo();
    }


    public void printAllDiscInfo() {
        List<DiscInfo> discInfos = discInfoDAO.getAll();
        Collections.sort(discInfos, comparing(DiscInfo::getTitle));
        for (DiscInfo discInfo : discInfos) {
            System.out.println(discInfo);
        }{

        }
    }

//    discInfo operations end

//    composition operations begin

    public void createComposition(Composition composition){
        System.out.println("Compositions before adding: ");
        printAllCompositions();

        compositionDAO.create(composition);

        System.out.println("\nCompositions after adding: ");
        printAllCompositions();

    }

    public void printAllCompositions(){
        List<Composition> compositions = new ArrayList<>();
        compositions = compositionDAO.getAll();
        for (Composition composition : compositions) {
            System.out.println(composition);
        }
    }

    public void deleteCompositionByTitleAndComposer (String title, String composerName){
        System.out.println("Compositions before deletion: ");
        printAllCompositions();

        compositionDAO.deleteByTitleAndComposer(title, composerName);

        System.out.println("Compositions before deletion: ");
        printAllCompositions();

    }
        public void printLengthByCompositionId (int compositionId){
            System.out.println(compositionDAO.getLengthById(compositionId));

        }
    //    composition operations end



}




