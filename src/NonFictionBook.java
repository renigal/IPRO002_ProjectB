enum NonFictionGenre{
    MEMOIR,
    BIOGRAPHY,
    MAGAZINES,
    SCIENCE,
    POLITICS,
    SELF_HELP,
    ECONOMICS,
    HEALTH,
    HOBBIES,
    TRAVEL,
    COOKBOOKS,
    RELIGION,
    HISTORY
}

public class NonFictionBook extends Book{
    private NonFictionGenre genre;

    public NonFictionBook(BookType type, String title, String author, String ISBN, NonFictionGenre genre){
        super(title, author, ISBN, type);
        this.genre = genre;
    }

    // Getter method to retrieve the genre of the non-fiction book
    public NonFictionGenre getNonFictionGenre(){
        return genre;
    }

    // Override the displayInfo method to provide specific information about the non-fiction book
    @Override
    public void displayInfo(){
        // Call the displayInfo method of the superclass to display common information
        super.displayInfo();
        // Display the genre of the non-fiction book
        System.out.println("Genre: " + getNonFictionGenre());
    }

    @Override
    public String toString() {
        return "NonFictionBook{" + "title='" + getTitle() + '\'' + ", author='" + getAuthor() + '\'' + ", ISBN='" + getISBN() + '\'' + ", type=" + getType() + ", genre=" + genre + ", isAvailable=" + getIsAvailable() + '}';
    }
}
