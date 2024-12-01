class BookLocation {
    private final String title;
    private final String author;
    private final String room;
    private final String cabinet;
    private final String shelf;

    public BookLocation(String title, String author, String room, String cabinet, String shelf) {
        this.title = title;
        this.author = author;
        this.room = room;
        this.cabinet = cabinet;
        this.shelf = shelf;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getRoom() {
        return room;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getShelf() {
        return shelf;
    }
}
