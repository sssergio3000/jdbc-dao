package musicCollection.entity;

public class DiscInfo {

    private int id;
    private String title;

    public DiscInfo() {
    }

    public DiscInfo(int id, java.lang.String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    @Override
    public java.lang.String toString() {
        return  "id=" + id +
                ", title=" + title + '\'' +
                '}';
    }
}
