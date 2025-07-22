public class PatternMaker {


    public static void printNumberTriangle(int rows) {
        System.out.println("\n--- Number Triangle (Rows: " + rows + ") ---");
        if (rows <= 0) {
            System.out.println("Number of rows must be positive.");
            return;
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //Prints a multiplication table for a given number up to a specified limit
    public static void printMultiplicationTable(int number, int limit) {
        System.out.println("\n--- Multiplication Table for " + number + " (Limit:" + limit + ") ---");
        if (limit <= 0) {
            System.out.println("Limit must be a positive");
            return;
        }
        for (int i = 1; i <= limit; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public static void main(String[] args) {
        // Test printNumberTriangle
        printNumberTriangle(4);
        printNumberTriangle(0);
        printNumberTriangle(6);

        // Test printMultiplicationTable
        printMultiplicationTable(7, 5);
        printMultiplicationTable(10, 0);
        printMultiplicationTable(3, 10);
    }
}

