import java.util.*;

interface User {
    String getName();
    String getType();
}

public class Student implements User {
    private String name;
    private Map<String, MediaItem> borrowedItems;
    private Map<String, MediaItem> availableItems;

    public Student(String name, Map<String, MediaItem> library){
        this.name = name;
        this.borrowedItems = new HashMap<>(); 
        this.availableItems = new HashMap<>(library); 
    }

    // Getter method to retrieve the name of the student
    @Override
    public String getName(){
        return name;
    }

    // Getter method to retrieve the type of the user
    @Override
    public String getType(){
        return "Student";
    }

    // Method for a student to borrow a media item
    public void borrowMediaItem(String title, String username) {
        boolean found = false;
        // Go through the available items
        for (Map.Entry<String, MediaItem> entry : availableItems.entrySet()) {
            String mediaTitle = entry.getKey();
            MediaItem mediaItem = entry.getValue();
            // Check if the title matches and the item is available
            if (mediaTitle.equalsIgnoreCase(title)) {
                if (mediaItem.getIsAvailable()) {
                    // If available, borrow the item
                    mediaItem.borrowMediaItem();
                    mediaItem.setBorrowerName(username);
                    borrowedItems.put(mediaTitle, mediaItem);
                    System.out.println(name + " has borrowed the media item: " + mediaTitle);
                } else {
                    // If not available, inform the student
                    System.out.println("Sorry, " + mediaTitle + " is not available for borrowing.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            // If title not found in available items, inform the student
            System.out.println("The media item '" + title + "' is not available in the library.");
        }
    }
    
    // Method for a student to return a borrowed media item
    public void returnMediaItem(String title) {
        boolean found = false;
        // Go through the available items
        for (Map.Entry<String, MediaItem> entry : borrowedItems.entrySet()) {
            String borrowedTitle = entry.getKey();
            MediaItem borrowedItem = entry.getValue();
            // Check if the title matches the borrowed item (ignores capital and lowercase)
            if (borrowedTitle.equalsIgnoreCase(title)) {
                // Return the borrowed item
                borrowedItem.returnMediaItem();
                borrowedItems.remove(borrowedTitle);
                System.out.println(name + " has returned the media item: " + borrowedTitle);
                found = true;
                break;
            }
        }
        if (!found) {
            // If title not found in borrowed items, inform the student
            System.out.println("You have not borrowed the media item '" + title + "'.");
        }
    }
    
    // Method for a student to view available media items in the library
    public void viewAvailableMediaItems(Map<String, MediaItem> library) {
        System.out.println("Available Media Items:");
        List<MediaItem> availableItems = new ArrayList<>();
        
        // Filter available items
        for (MediaItem item : library.values()) {
            if (item.getIsAvailable()) {
                availableItems.add(item);
            }
        }
        
        // Sort available items by title
        Collections.sort(availableItems, (item1, item2) -> item1.getTitle().compareTo(item2.getTitle()));
        
        // Display available items
        if (availableItems.isEmpty()) {
            System.out.println("No media items are currently available for borrowing.");
        } else {
            for (MediaItem item : availableItems) {
                String itemType = "";
                // Determine the type of the item
                if (item instanceof FictionBook) {
                    itemType = "Fiction Book";
                } else if (item instanceof NonFictionBook) {
                    itemType = "Non-Fiction Book";
                } else if (item instanceof DVD) {
                    itemType = "DVD";
                } else if (item instanceof VinylRecord) {   
                    itemType = "Vinyl Record";
                }
                System.out.println("- " + item.getTitle() + " (" + itemType + ")");
            }
        }
    }
    
    // Method for a student to display borrowed media items
    public void displayBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("You haven't borrowed any media items.");
        } else {
            System.out.println("Borrowed Media Items:");
            for (MediaItem item : borrowedItems.values()) {
                System.out.println("- " + item.getTitle());
            }
        }
    }

    // Method for a student to view details of a media item
    public void viewMediaItemDetails(String title, Map<String, MediaItem> library) {
        boolean found = false;
        // Loop through the library to find a title
        for (MediaItem item : library.values()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                // Display details of the found item
                item.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            // If title not found, inform the student
            System.out.println("Media item with title '" + title + "' not found.");
        }
    }

    public Map<String, MediaItem> getBorrowedItems(){
        return borrowedItems;
    }

    public void addBorrowedItems(MediaItem item){
        borrowedItems.put(item.getTitle(), item);
    }

    public void removeBorrowedItems(String title){
        borrowedItems.remove(title);
    }

    @Override
    public String toString() {
        String result = "Student Name: " + name + "\n";
        result += "Borrowed Items: \n";
        for (MediaItem item : borrowedItems.values()) {
            result += "- " + item.getTitle() + "\n";
        }
        result += "Available Items: \n";
        for (MediaItem item : availableItems.values()) {
            result += "- " + item.getTitle() + "\n";
        }
        return result;
    }
}
