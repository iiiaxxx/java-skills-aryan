public class UserInfo {


    private String name;
    private int age;
    private String email;
    private boolean isActive;

    // Create constructor that takes all parameters
    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    // Create getter and setter methods for all variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Create a method that displays user info nicely formatted
    public void displayInfo() {
        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("------------------------");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create 3 different users
        UserInfo user1 = new UserInfo("Aryan", 30, "aryan123@gmail.com", true);
        UserInfo user2 = new UserInfo("Sara", 24, "sara123@gmail.com", false);
        UserInfo user3 = new UserInfo("Alya", 45, "alya123@gmail.com", true);

        // Display their information
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        // Test your getters and setters
        System.out.println("\n--- Testing Getters and Setters ---");
        System.out.println("User 1's current email: " + user1.getEmail());
        user1.setEmail("alice.s@newdomain.com");
        System.out.println("User 1's new email: " + user1.getEmail());

        System.out.println("User 2's current status: " + user2.isActive());
        user2.setActive(true);
        System.out.println("User 2's new status: " + user2.isActive());
        user2.displayInfo();
    }
}


