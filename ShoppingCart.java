public class ShoppingCart {

    //Calculates the total price of items in a shopping cart with discounts based on customer type.
    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;

        // First, calculate sum of all prices using a loop
        for (double price : prices) {
            total += price;
        }

        // Then apply discount based on customer type using switch
        switch (customerType.toUpperCase()) {
            case "REGULAR":
                // no discount
                break;
            case "PREMIUM":
                total *= 0.90; // 10% discount
                break;
            case "VIP":
                total *= 0.80; // 20% discount
                break;
            default:
                System.out.println("Warning: Invalid customer type. No discount applied.");
                break;
        }
        return total;
    }

    //Finds the most expensive item in an array of prices

    public static double findMostExpensive(double[] prices) {
        if (prices == null || prices.length == 0) {
            System.out.println("Warning: Price array is empty or null. so returnn 0");
            return 0;
        }

        double mostExpensive = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > mostExpensive) {
                mostExpensive = prices[i];
            }
        }
        return mostExpensive;
    }

    //Counts how many items cost more than a certain threshold

    public static int countExpensiveItems(double[] prices, double threshold) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        System.out.println("--- Shopping Cart Tests ---");

        // Test with different customer types
        System.out.println("Regular customer total:$" + String.format("%.2f", calculateTotal(cart, "REGULAR")));
        System.out.println("Premium customer total:$" + String.format("%.2f", calculateTotal(cart, "PREMIUM")));
        System.out.println("VIP customer total:$" + String.format("%.2f", calculateTotal(cart, "VIP")));
        System.out.println("Unknown customer total:$" + String.format("%.2f", calculateTotal(cart, "UNKNOWN")));

        // Find most expensive item
        System.out.println("\nMost expensive item: $" + String.format("%.2f", findMostExpensive(cart)));
        System.out.println("Most expensive item in empty cart: $" + String.format("%.2f", findMostExpensive(new double[]{})));

        // Count items that is over $30
        System.out.println("\nItems over $30: " + countExpensiveItems(cart, 30.0));
        System.out.println("Items over $100: " + countExpensiveItems(cart, 100.0));
        System.out.println("Items over $10 in empty cart: " + countExpensiveItems(new double[]{}, 10.0));
    }
}

