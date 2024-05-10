import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Create some media items
        Map<String, MediaItem> library = new HashMap<>();
        Staff librarian = new Staff();
        
        // Add some books
        librarian.addMediaItem("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", FictionGenre.ROMANCE, library);
        librarian.addMediaItem("To Kill a Mockingbird", "Harper Lee", "9780061120084", FictionGenre.DRAMA, library);
        librarian.addMediaItem("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", NonFictionGenre.HISTORY, library);
        
        // Add a DVD
        librarian.addMediaItem("Inception", "Christopher Nolan", "2010", library);
        
        // Add a vinyl record
        librarian.addMediaItem("Abbey Road", "The Beatles", 17, library);
        
        // Create a student
        Student student = new Student("Alice", library);
        
        // Display available media items
        student.viewAvailableMediaItems(library);
        
        // Student borrows a book
        student.borrowMediaItem();
        
        // Display borrowed items 
        student.displayBorrowedItems();
        
        // Display available media items after borrowing (the great gatsby disappear from list)
        student.viewAvailableMediaItems(library);
        
        // Student tries to borrow a book that's not available
        student.borrowMediaItem("Inception");
        
        // Student returns a book
        student.returnMediaItem("The Great Gatsby");
        
        // Display borrowed items after returning 
        student.displayBorrowedItems();
        
        // Display available media items after returning (the great gatsby return, inception disappear)
        student.viewAvailableMediaItems(library);
        
        // Librarian lists all media items
        librarian.listAllMediaItems(library);
        
        // Librarian removes a media item (staff can't remove 'incetion', since its still being borrowed)
        librarian.removeMediaItem("Inception", library);
        
        // Librarian lists all media items after removal
        librarian.listAllMediaItems(library);
    }
}
