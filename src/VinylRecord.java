public class VinylRecord extends MediaItem {
    private String artist;
    private int numberOfTracks;

    public VinylRecord(String title, String artist, int numberOfTracks){
        super(title);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    // Getter method to retrieve the artist of the vinyl record
    public String getArtist(){
        return artist;
    }

    // Getter method to retrieve the number of tracks of the vinyl record
    public int getNumberOfTracks(){
        return numberOfTracks;
    }

    // Override the displayInfo method to provide specific information about the vinyl record
    @Override
    public void displayInfo(){
        // Display the title, artist, and number of tracks of the vinyl record
        System.out.println("Title: " + getTitle() + ", Artist: " + getArtist() + ", Number of Tracks: " + getNumberOfTracks());
    }

    @Override
    public String toString() {
        return "VinylRecord{" + "title='" + getTitle() + '\'' + ", artist='" + artist + '\'' + ", numberOfTracks=" + numberOfTracks + ", isAvailable=" + getIsAvailable() + '}';
    }
}
