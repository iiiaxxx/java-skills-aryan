public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;

    // Non-static variable for individual session
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++; // Increment total when new visitor is created
    }

    // Non-static method
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    // Static method
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static method to get total (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args) {
        System.out.println("--- Visitor Counter Test ---");

        // Display initial total visitors
        displayTotalVisitors(); // Expected: 0

        // Create 3 different visitors
        VisitorCounter visitor1 = new VisitorCounter("Aryan");
        VisitorCounter visitor2 = new VisitorCounter("sara");
        VisitorCounter visitor3 = new VisitorCounter("alya");

        // Display total visitors after creation
        displayTotalVisitors();

        // Have each visitor record some visits
        System.out.println("\n--- Recording Visits ---");
        visitor1.recordVisit();
        visitor1.recordVisit();
        visitor2.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();

        // Display total visitors using static method
        System.out.println("\n--- Final Total Visitors ---");
        displayTotalVisitors();

        // Test getTotalVisitors getter
        System.out.println("Total visitors via getter: " + getTotalVisitors());
    }
}

