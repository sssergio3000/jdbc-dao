package musicCollection.entity;

public class DiscInfo {

    private int id;
    private String title;

    public DiscInfo() {
    }

    public DiscInfo(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "DiscInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
