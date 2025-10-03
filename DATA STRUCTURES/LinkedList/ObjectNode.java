// LINKED LISTS FOR STORING CUSTOM DATA TYPES/ OBJECTS
class Book {
    private String title, author;
    private int publishYear;
    public Book(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }
    @Override
    public String toString() {
        return "BOOK TITLE : " + title + " , AUTHOR " + author + " AND PUBLISHING YEAR : " + publishYear;
    }
}
public class ObjectNode {
    private Object data;
    private ObjectNode next;
    public ObjectNode(Object data) {
        this.data = data;
    }
    public static void display(ObjectNode start) {
        for (ObjectNode i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
    public static void main(String[] args) {
        Book b1 = new Book("CRICKET","BEN STOKES",2019);
        Book b2 = new Book("FOOTBALL","CRISTIANO RONALDO",2015);
        Book b3 = new Book("CHESS","MAGNUS CARLSEN",2025);
        Book b4 = new Book("KABADDI","PARDEEP NARWAL",2021);

        ObjectNode start = new ObjectNode(b1);
        start.next = new ObjectNode(b2);
        start.next.next = new ObjectNode(b3);
        start.next.next.next = new ObjectNode(b4);
        display(start);
    }
}
