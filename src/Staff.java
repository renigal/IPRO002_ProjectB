import java.util.*;

public class Staff implements User {
    private String name;

    public Staff(String name, Map<String, MediaItem> library) {
        this.name = name;
    }

    // Getter method to retrieve the name of the staff member
    @Override
    public String getName(){
        return name;
    }

    // Getter method to retrieve the type of the user
    @Override
    public String getType(){
        return "Staff";
    }

    // Method to add a fiction book to the library
    public void addMediaItem(String title, String author, String ISBN, FictionGenre genre, Map<String, MediaItem> library){
        // Create a new fiction book instance
        FictionBook book = new FictionBook(BookType.FICTION, title, author, ISBN, genre);
        // Call the overloaded method to add the media item to the library
        addMediaItem(book, library);
    }
    
    // Method to add a non-fiction book to the library
    public void addMediaItem(String title, String author, String ISBN, NonFictionGenre genre, Map<String, MediaItem> library){
        // Create a new non-fiction book instance
        NonFictionBook book = new NonFictionBook(BookType.NON_FICTION, title, author, ISBN, genre);
        // Call the overloaded method to add the media item to the library
        addMediaItem(book, library);
    }

    // Method to add a DVD to the library
    public void addMediaItem(String title, String director, String yearReleased, Map<String, MediaItem> library){
        // Create a new DVD instance
        DVD dvd = new DVD(title, director, yearReleased);
        // Call the overloaded method to add the media item to the library
        addMediaItem(dvd, library);
    }

    // Method to add a vinyl record to the library
    public void addMediaItem(String title, String artist, int numberOfTracks, Map<String, MediaItem> library){
        // Create a new vinyl record instance
        VinylRecord vinylRecord = new VinylRecord(title, artist, numberOfTracks);
        // Call the overloaded method to add the media item to the library
        addMediaItem(vinylRecord, library);
    }

    // Method to add a media item to the library
    private void addMediaItem(MediaItem item, Map<String, MediaItem> library){
        // Check if the item already exists in the library
        if (library.containsKey(item.getTitle())){
            System.out.println(item.getTitle() + " already exists in the library.");
        } else {
            // If not, add the item to the library
            library.put(item.getTitle(), item);
            System.out.println(item.getTitle() + " has been added to the library.");
        }
    }

    // Method to remove a media item from the library
    public void removeMediaItem(String title, Map<String, MediaItem> mediaItems) {
        boolean found = false;
        // Go through each media item in library
        for (Iterator<Map.Entry<String, MediaItem>> iterator = mediaItems.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, MediaItem> entry = iterator.next();
            String itemTitle = entry.getKey();
            // Check if the title matches the item (ignore upper and lower case)
            if (itemTitle.equalsIgnoreCase(title)) {
                MediaItem item = entry.getValue();
                // Check if the item is available
                if (item.getIsAvailable()) {
                    // If available, remove the item from the library
                    iterator.remove();
                    System.out.println(itemTitle + " has been removed from the library.");
                } else {
                    // If not available, inform the staff
                    System.out.println(itemTitle + " cannot be removed as it is currently borrowed.");
                }
                found = true;
            }
        }
        // If title not found in the library, inform the staff
        if (!found) {
            System.out.println(title + " is not available in the library.");
        }
    }
    
    public void listAllMediaItems(Map<String, MediaItem> library, Map<String, Student> students) {
        for (Map.Entry<String, MediaItem> entry : library.entrySet()) {
            MediaItem item = entry.getValue();
            String borrowerUsername = item.getBorrowerUsername();
            if (borrowerUsername != null) {
                // Check if the borrower is a student
                Student student = students.get(borrowerUsername);
                if (student != null) {
                    System.out.println(entry.getKey() + " (Borrowed by: " + student.getName() + ")");
                } else {
                    // If borrower is not a student, just display the username
                    System.out.println(entry.getKey() + " (Borrowed by: " + borrowerUsername + ")");
                }
            } else {
                System.out.println(entry.getKey() + " (Available)");
            }
        }
    }
    
    

    // Method to view details of a media item in the library
    public void viewMediaItemDetails(String title, Map<String, MediaItem> library) {
        boolean found = false;
        // Go through each item in the library
        for (MediaItem item : library.values()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                // Display details of the found item
                item.displayInfo();
                found = true;
                break;
            }
        }
        // If title not found in the library, inform the staff
        if (!found) {
            System.out.println("Media item with title '" + title + "' not found.");
        }
    }

    @Override
    public String toString() {
        return "Staff Name: " + name; 
    }
}
