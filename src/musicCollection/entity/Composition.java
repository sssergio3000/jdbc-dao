package musicCollection.entity;

public class Composition {
    private long id;
    private String title;
    private Composer composer;
    private Style style;
    private int length;


    public Composition(long id, String title, Composer composer, Style style, int length ) {
        this.id = id;
        this.title = title;
        this.composer = composer;
        this.length = length;
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", composer=" + composer +
                ", length=" + length +
                ", style=" + style +
                '}';
    }
}
