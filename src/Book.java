public class Book extends MediaItem {
    private String author;
    private String ISBN;
    private BookType type;

    public Book(String title, String author, String ISBN, BookType type){
        super(title);
        this.author = author;
        this.ISBN = ISBN;
        this.type = type;
    }

    // Getter method to retrieve the author of the book
    public String getAuthor(){
        return author;
    }

    // Getter method to retrieve the ISBN of the book
    public String getISBN(){
        return ISBN;
    }

    // Getter method to retrieve the type of the book
    public String getType(){
        // Convert the BookType enum to a string representation
        return type.name();
    }

    // Override the displayInfo method to provide specific information about the book
    @Override
    public void displayInfo(){
        // Display the title, author, type, and ISBN of the book
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + " , Type: " + getType() + ", ISBN:" + getISBN());
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + getTitle() + '\'' + ", author='" + author + '\'' + ", ISBN='" + ISBN + '\'' + ", type=" + type + ", isAvailable=" + getIsAvailable() + '}';
    }
}

// Enum to represent the type of a book (fiction or non-fiction)
enum BookType{
    FICTION,
    NON_FICTION
}
