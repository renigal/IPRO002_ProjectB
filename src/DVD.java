public class DVD extends MediaItem {
    private String director;
    private String yearReleased;

    public DVD(String title, String director, String yearReleased){
        super(title);
        this.director = director;
        this.yearReleased = yearReleased;
    }

    // Getter method to retrieve the director of the DVD
    public String getDirector(){
        return director;
    }

    // Getter method to retrieve the year released of the DVD
    public String getReleaseYear(){
        return yearReleased;
    }

    // Override the displayInfo method to provide specific information about the DVD
    @Override
    public void displayInfo(){
        // Display the title, director, and year released of the DVD
        System.out.println("Title: " + getTitle() + ", Director: " + getDirector() + ", Release Year: " + getReleaseYear());
    }

    @Override
    public String toString() {
        return "DVD{" + "title='" + getTitle() + '\'' + ", director='" + director + '\'' + ", yearReleased='" + yearReleased + '\'' + ", isAvailable=" + getIsAvailable() + '}';
    }
}
