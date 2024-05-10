import java.util.*;

public class Login {
    private Map<String, String> userCredentials;

    public Login() {
        // Initialize the user credentials map
        userCredentials = new HashMap<>();
        // Add some default users (username, password)
        userCredentials.put("student1", "password1");
        userCredentials.put("student2", "password2");
        userCredentials.put("staff1", "password3");
    }

    public boolean authenticate(String username, String password) {
        // Check if the username exists and the password matches
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public String getUserType(String username) {
        // Determine the type of the user based on the username
        if (username.startsWith("student")) {
            return "Student";
        } else if (username.startsWith("staff")) {
            return "Staff";
        } else {
            return "Unknown";
        }
    }
}
