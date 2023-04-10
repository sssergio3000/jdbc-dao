package musicCollection;

import musicCollection.entity.Composer;

public class Main {

    public static void main(String[] args) {
        MusicService ms = new MusicService();
        ms.printAllComposers();
//        ms.createNewComposer(new Composer(0, "Madonna"));
    }
}
