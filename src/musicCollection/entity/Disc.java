package musicCollection.entity;

import java.util.List;

public class Disc {
    private  int id;
    private  List<Composition> list;


    public Disc(int id, List<Composition> list) {
        this.id = id;
        this.list = list;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Composition> getList() {
        return list;
    }

    public void setList(List<Composition> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String str = "Disc ID: " + getId()+" Compositions: ";
        for (Composition composition : list) {
            str+= composition.getId()+", ";

        }
        return str;
    }
}
