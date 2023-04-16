package musicCollection;

import musicCollection.entity.Composer;
import musicCollection.entity.Composition;
import musicCollection.entity.Style;

public class Main {

    public static void main(String[] args) {
        MusicService ms = new MusicService();
//        ms.printAllComposers();
//        ms.createNewComposer(new Composer(0, "Sting"));
//        ms.deleteComposerByName("Sting");
//        ms.readComposerByName("Vadonna");
//        ms.createStyle("JJJ");
//        ms.deleteStyleByTitle("Popsa");
//        ms.deleteDiscInfoById(4);
        ms.printAllCompositions();
//        ms.createComposition(new Composition(0,"it's my life", new Composer(0, "Bon Jovi"), new Style(0, "rock"), 111));
//        ms.deleteCompositionByTitleAndComposer("true love", "abba");
//        ms.printLengthByCompositionId(7);

    }
}
