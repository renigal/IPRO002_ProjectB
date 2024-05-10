import java.util.*;

// This class serves as the entry point for the library management system
public class LibraryInterface {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String, MediaItem> library = new HashMap<>(); // Initialize a HashMap to store media items

        // Sample Library
        // Create sample media items and add them to the library
        MediaItem book1 = new FictionBook(BookType.FICTION, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", FictionGenre.ROMANCE);
        MediaItem book2 = new NonFictionBook(BookType.NON_FICTION, "Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "9780062316097", NonFictionGenre.HISTORY);
        MediaItem dvd1 = new DVD("Inception", "Christopher Nolan", "2010");
        MediaItem vinyl1 = new VinylRecord("Abbey Road", "The Beatles", 17);

        // Add sample media items to the library
        library.put(book1.getTitle(), book1);
        library.put(book2.getTitle(), book2);
        library.put(dvd1.getTitle(), dvd1);
        library.put(vinyl1.getTitle(), vinyl1);

        Login login = new Login();
        Map<String, Student> students = new HashMap<>();    

        int choice;

        // Display main menu and handle user choice
        do {
            try {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Login as Student");
                System.out.println("2. Login as Staff");
                System.out.println("3. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        loginStudent(scanner, library, login, students); // Login as student
                        break;
                    case 2:
                        loginStaff(scanner, library, login, students); // Login as staff
                        break;
                    case 3:
                        System.out.println("Exiting Library System");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                choice = 0; 
            }
        } while (choice != 3);

        scanner.close();
    }

    // Method for student menu
    private static void studentMenu(Scanner scanner, Student student, Map<String, MediaItem> library, String username) {
        int option;

        // Display student menu and handle user choice
        do {
            try{
                System.out.println("\nStudent Menu:");
                System.out.println("1. Borrow Media Item");
                System.out.println("2. Return Media Item");
                System.out.println("3. View Available Media Items");
                System.out.println("4. View Borrowed Items");
                System.out.println("5. Display Media Item Details");
                System.out.println("6. Logout");
                System.out.println("Enter choice: ");

                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch(option) {
                    case 1:
                        System.out.println("Enter a media name to borrow: ");
                        String mediaName = scanner.nextLine();
                        student.borrowMediaItem(mediaName, username); // Borrow media item
                        break;
                    case 2:
                        System.out.println("Enter a title to return: ");
                        String title = scanner.nextLine();
                        student.returnMediaItem(title); // Return media item
                        break;
                    case 3:
                        student.viewAvailableMediaItems(library); // View available media items
                        break;
                    case 4:
                        student.displayBorrowedItems(); // View borrowed items
                        break;
                    case 5:
                        System.out.println("Enter title of media item:");
                        String itemName = scanner.nextLine();
                        student.viewMediaItemDetails(itemName, library); // View media item details
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                option = 0; 
            }
        } while (option != 6);
    }


    // Method for staff login
    private static void staffMenu(Scanner scanner, Staff staff, Map<String, MediaItem> library, Map<String, Student> students){
                int action;

                // Display staff menu and handle user choice
                do {
                    try{
                    System.out.println("\nStaff Menu");
                    System.out.println("1. Add Media Item");
                    System.out.println("2. Remove Media Item");
                    System.out.println("3. List all Media Items");
                    System.out.println("4. Display Media Item Details");
                    System.out.println("5. Logout");
                    System.out.println("Enter choice: ");
    
                    action = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
    
                    switch (action) {
                        case 1:
                            addMediaItemMenu(scanner, staff, library); // Add media item
                            break;
                        case 2:
                            removeMediaItem(scanner, staff, library); // Remove media item
                            break;
                        case 3:
                            staff.listAllMediaItems(library, students); // List all media items
                            break;
                        case 4:
                            System.out.println("Enter title of media item:");
                            String itemName = scanner.nextLine();
                            staff.viewMediaItemDetails(itemName, library); // View details of a media item
                            break;
                        case 5:
                            System.out.println("Staff logged out");
                            return; // Exit the method and return to main menu
                        default:
                            System.out.println("Invalid choice!");
                    }
                } catch(InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                action = 0;
                }
                } while (action != 5);
    }
    
    // Method to remove a media item by staff
    private static void removeMediaItem(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter Media Item Title:");
        String title = scanner.nextLine();

        staff.removeMediaItem(title, library); // Remove media item
    }

    // Method to display menu for adding media items by staff
    private static void addMediaItemMenu(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        int mediaTypeChoice;

        System.out.println("\nAdd Media Item:");
        System.out.println("1. Add Fiction Book");
        System.out.println("2. Add Non-Fiction Book");
        System.out.println("3. Add DVD");
        System.out.println("4. Add Vinyl Record");
        System.out.println("5. Back to Staff Menu");
        System.out.println("Enter choice:");

        mediaTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (mediaTypeChoice){
            case 1:
                addFictionBook(scanner, staff, library); // Add fiction book
                break;
            case 2:
                addNonFictionBook(scanner, staff, library); // Add non-fiction book
                break;
            case 3:
                addDVD(scanner, staff, library); // Add DVD
                break;
            case 4:
                addVinyl(scanner, staff, library); // Add vinyl record
                break;
            case 5:
                System.out.println("Returning to Staff Menu...");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    // Method to add a fiction book by staff
    private static void addFictionBook(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();

        // Display a prompt to select a genre and enumerate the available fiction genres along with their index.
        System.out.println("Select Genre:");
        // The index is incremented by 1 to start from 1 instead of 0 for user-friendly display.
        // Each genre is displayed with its corresponding index followed by a period and the genre name.
        for (FictionGenre genre : FictionGenre.values()) {
            System.out.println(genre.ordinal() + 1 + ". " + genre);
        }
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // This line retrieves the NonFictionGenre enum constant corresponding to the user's choice.
        // NonFictionGenre.values() returns an array containing all the enum constants of NonFictionGenre,
        // and genreChoice - 1 is used to index the array based on the user's input,
        // adjusting for zero-based indexing.
        FictionGenre genre = FictionGenre.values()[genreChoice - 1];

        staff.addMediaItem(title, author, isbn, genre, library); // Add fiction book
    }

    // Method to add a non-fiction book by staff
    private static void addNonFictionBook(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();

        // Display a prompt to select a genre and enumerate the available fiction genres along with their index.
        System.out.println("Select Genre:");
        // The index is incremented by 1 to start from 1 instead of 0 for user-friendly display.
        // Each genre is displayed with its corresponding index followed by a period and the genre name.
        for (NonFictionGenre genre : NonFictionGenre.values()) {
            System.out.println(genre.ordinal() + 1 + ". " + genre);
        }
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // This line retrieves the NonFictionGenre enum constant corresponding to the user's choice.
        // NonFictionGenre.values() returns an array containing all the enum constants of NonFictionGenre,
        // and genreChoice - 1 is used to index the array based on the user's input,
        // adjusting for zero-based indexing.
        NonFictionGenre genre = NonFictionGenre.values()[genreChoice - 1];

        staff.addMediaItem(title, author, isbn, genre, library); // Add non-fiction book
    }

    // Method to add a DVD by staff
    private static void addDVD(Scanner scanner, Staff staff, Map<String, MediaItem> library) {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Director: ");
        String director = scanner.nextLine();

        System.out.print("Enter Release Year: ");
        String yearReleased = scanner.nextLine();

        staff.addMediaItem(title, director, yearReleased, library); // Add DVD
    }

    // Method to add a vinyl record by staff
    private static void addVinyl(Scanner scanner, Staff staff, Map<String, MediaItem> library){
        System.out.println("Enter Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Artist:");
        String artist = scanner.nextLine();

        System.out.println("Enter the Number of Tracks:");
        int numoftracks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        staff.addMediaItem(title, artist, numoftracks, library); // Add vinyl record
    }

    private static void loginStudent(Scanner scanner, Map<String, MediaItem> library, Login login, Map<String, Student> students){
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if (login.authenticate(username, password)){
            String userType = login.getUserType(username);
            if ("Student" == userType){
                System.out.println("Login Successful");
                Student student = new Student(username, library);
                studentMenu(scanner, student, library, username);
            } else {
                System.out.println("Invalid User Type");
            }
        } else {
            System.out.println("Invalid username or password");
        }
    }

    private static void loginStaff(Scanner scanner, Map<String, MediaItem> library, Login login, Map<String, Student> students){
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if (login.authenticate(username, password)){
            String userType = login.getUserType(username);
            if("Staff" == userType){
                System.out.println("Login Successful");
                Staff staff = new Staff(username, library);
                staffMenu(scanner, staff, library, students);
            } else {
                System.out.println("Invalid User Type");
            }
        } else {
            System.out.println("Invalid username or password");
        }
    }
}