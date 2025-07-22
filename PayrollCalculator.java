public class PayrollCalculator {


    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        double weeklyPay = 0;

        // Handle invalid employee types and negative values
        if (hoursWorked < 0 || hourlyRate < 0) {
            System.out.println("Error: Hours worked and hourly rate cant negative");
            return 0;
        }

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                // Regular pay for 40 hours, overtime (1.5x) for hours > 40
                if (hoursWorked > 40) {
                    weeklyPay = (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                } else {
                    weeklyPay = hoursWorked * hourlyRate;
                }
                break;
            case "PART_TIME":
                // Regular pay, no overtime, max 25 hours
                if (hoursWorked > 25) {
                    System.out.println("Warning: Part-time employee cannot work more than 25 hours. Pay calculated for 25 hours.");
                    weeklyPay = 25 * hourlyRate;
                } else {
                    weeklyPay = hoursWorked * hourlyRate;
                }
                break;
            case "CONTRACTOR":
                // Flat rate, no overtime rules
                weeklyPay = hoursWorked * hourlyRate;
                break;
            case "INTERN":
                // 20% discount from hourly rate, max 20 hours
                if (hoursWorked > 20) {
                    System.out.println("Warning: Intern cannot work more than 20 hours. Pay calculated for 20 hours.");
                    weeklyPay = 20 * (hourlyRate * 0.8);
                } else {
                    weeklyPay = hoursWorked * (hourlyRate * 0.8);
                }
                break;
            default:
                System.out.println("Error: Invalid employee type: " + employeeType);
                break;
        }
        return weeklyPay;
    }

    // Calculates tax deduction based on gross pay and health insurance status.
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0;

        if (grossPay < 0) {
            System.out.println("Error: Gross pay cannot be negative.");
            return 0;
        }

        // Tax brackets using nested if-else:
        // $0-500: 10% tax
        // $501-1000: 15% tax
        // $1001-2000: 20% tax
        // Above $2000: 25% tax
        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = (500 * 0.10) + ((grossPay - 500) * 0.15);
        } else if (grossPay <= 2000) {
            tax = (500 * 0.10) + (500 * 0.15) + ((grossPay - 1000) * 0.20);
        } else {
            tax = (500 * 0.10) + (500 * 0.15) + (1000 * 0.20) + ((grossPay - 2000) * 0.25);
        }

        // If hasHealthInsurance is true, reduce tax by $50
        if (hasHealthInsurance) {
            tax -= 50;
        }

        // Ensure tax doesn't go below zero
        return Math.max(0, tax);
    }

    //Processes multiple employees and finds statistics.

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        // Handle arrays of different lengths gracefully
        if (employeeTypes.length != hours.length || employeeTypes.length != rates.length || employeeTypes.length != names.length) {
            System.out.println("Error: Input arrays must have the same length.");
            return;
        }

        double highestPay = 0;
        String highestPaidEmployee = "";
        double lowestPay = Double.MAX_VALUE;
        String lowestPaidEmployee = "";
        double totalPay = 0;
        int overtimeEmployees = 0;

        System.out.println("\n--- Payroll Report ---");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Gross Pay");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < employeeTypes.length; i++) {
            double currentPay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            totalPay += currentPay;

            if (currentPay > highestPay) {
                highestPay = currentPay;
                highestPaidEmployee = names[i];
            }

            if (currentPay < lowestPay) {
                lowestPay = currentPay;
                lowestPaidEmployee = names[i];
            }

            if (employeeTypes[i].equalsIgnoreCase("FULL_TIME") && hours[i] > 40) {
                overtimeEmployees++;
            }
            System.out.printf("%-15s %-10s %-10.1f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], rates[i], currentPay);
        }

        double averagePay = totalPay / employeeTypes.length;

        System.out.println("----------------------------------------------------------");
        System.out.println("\n--- Payroll Statistics ---");
        System.out.printf("Highest Paid Employee: %s ($%.2f)\n", highestPaidEmployee, highestPay);
        System.out.printf("Lowest Paid Employee: %s ($%.2f)\n", lowestPaidEmployee, lowestPay);
        System.out.printf("Average Pay:$%.2f\n", averagePay);
        System.out.printf("Number of Employees with Overtime: %d\n", overtimeEmployees);
    }

    public static void main(String[] args) {
        // Test data:
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"aryan", "sara", "dana", "alya", "meera"};

        // Test individual calculations first
        System.out.println("\n--- Individual Pay Calculation Tests ---");
        System.out.printf("aryan (FULL_TIME, 45h, $25/h): $%.2f\n", calculateWeeklyPay("FULL_TIME", 45, 25)); // Expected: 40*25 + 5*25*1.5 = 1000 + 187.5 = 1187.5
        System.out.printf("sara (PART_TIME, 20h, $18/h): $%.2f\n", calculateWeeklyPay("PART_TIME", 20, 18)); // Expected: 20*18 = 360
        System.out.printf("dana (CONTRACTOR, 35h, $40/h): $%.2f\n", calculateWeeklyPay("CONTRACTOR", 35, 40)); // Expected: 35*40 = 1400
        System.out.printf("alya (INTERN, 15h, $12/h): $%.2f\n", calculateWeeklyPay("INTERN", 15, 12)); // Expected: 15 * (12 * 0.8) = 15 * 9.6 = 144
        System.out.printf("meera (FULL_TIME, 50h, $30/h): $%.2f\n", calculateWeeklyPay("FULL_TIME", 50, 30)); // Expected: 40*30 + 10*30*1.5 = 1200 + 450 = 1650
        System.out.printf("Invalid Type (UNKNOWN, 10h, $10/h): $%.2f\n", calculateWeeklyPay("UNKNOWN", 10, 10)); // Expected: Error message 0
        System.out.printf("Negative Hours (FULL_TIME, -5h, $10/h): $%.2f\n", calculateWeeklyPay("FULL_TIME", -5, 10)); // Expected: Error message 0

        System.out.println("\n--- Individual Tax Calculation Tests ---");
        System.out.printf("Tax on $400 (no insurance): $%.2f\n", calculateTaxDeduction(400, false)); // Expected: 40
        System.out.printf("Tax on $700 (no insurance): $%.2f\n", calculateTaxDeduction(700, false)); // Expected: 50 + (200 * 0.15) = 50 + 30 = 80
        System.out.printf("Tax on $1500 (no insurance): $%.2f\n", calculateTaxDeduction(1500, false)); // Expected: 50 + 75 + (500 * 0.20) = 125 + 100 = 225
        System.out.printf("Tax on $2500 (no insurance): $%.2f\n", calculateTaxDeduction(2500, false)); // Expected: 50 + 75 + 200 + (500 * 0.25) = 325 + 125 = 450
        System.out.printf("Tax on $700 (with insurance): $%.2f\n", calculateTaxDeduction(700, true)); // Expected: 80 - 50 = 30
        System.out.printf("Tax on $40 (with insurance): $%.2f\n", calculateTaxDeduction(40, true)); // Expected: 4 - 50 = -46 -> 0

        // Then process the entire payroll
        processPayroll(types, hours, rates, names);
    }
}

