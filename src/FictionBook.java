// Enum to represent genres of fiction books
enum FictionGenre{
    HORROR,
    MYSTERY,
    ROMANCE,
    SCIENCE_FICTION,
    THRILLER,
    FANTASY,
    HISTORY,
    DRAMA
}

public class FictionBook extends Book{
    private FictionGenre genre;

    public FictionBook(BookType type, String title, String author, String ISBN, FictionGenre genre){
        super(title, author, ISBN, type);
        this.genre = genre;
    }

    // Getter method to retrieve the genre of the fiction book
    public FictionGenre getFictionGenre(){
        return genre;
    }
    
    // Override the displayInfo method to provide specific information about the fiction book
    @Override
    public void displayInfo(){
        // Call the displayInfo method of the superclass to display common information
        super.displayInfo();
        // Display the genre of the fiction book
        System.out.println("Genre: " + getFictionGenre());
    }

    @Override
    public String toString() {
        return "FictionBook{" + "title='" + getTitle() + '\'' + ", author='" + getAuthor() + '\'' + ", ISBN='" + getISBN() + '\'' + ", type=" + getType() + ", genre=" + genre + ", isAvailable=" + getIsAvailable() + '}';
    }
}
