import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GradeManager {

    //Reverses each individual student name in an array.

    public static String[] reverseStudentNames(String[] names) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reversedNames[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversedNames;
    }

    //Calculates the letter grade for a given score.

    public static char getLetterGrade(int score) {
        if (score < 0 || score > 100) {
            System.out.println("Warning: Score out of valid range (0-100). Returning 'N' for Not Applicable.");
            return 'N'; // Not Applicable means Error
        }

        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    //Finds students who need to retake the exam (score below 60).

    public static String[] findFailingStudents(String[] names, int[] scores) {
        if (names == null || scores == null || names.length != scores.length) {
            System.out.println("Error: Names and scores arrays must be non-null and of the same length.");
            return new String[0];
        }

        ArrayList<String> failingStudentsList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (scores[i] < 60) {
                failingStudentsList.add(names[i]);
            }
        }
        return failingStudentsList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] students = {"Aryan", "sara", "alya", "maryam"};
        int[] scores = {95, 67, 45, 78};

        System.out.println("--- Student Grade Manager Tests ---");

        // Test reverseStudentNames
        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Original Names: " + Arrays.toString(students));
        System.out.println("Reversed Names: " + Arrays.toString(reversedNames));

        // Test getLetterGrade
        System.out.println("\n--- Letter Grades ---");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + " (Score: " + scores[i] + "): " + getLetterGrade(scores[i]));
        }
        System.out.println("Score 105: " + getLetterGrade(105)); // Test out of range
        System.out.println("Score -5: " + getLetterGrade(-5));   // Test out of range

        // Test findFailingStudents
        String[] failingStudents = findFailingStudents(students, scores);
        System.out.println("\n--- Failing Students ---");
        if (failingStudents.length > 0) {
            System.out.println("Students who need to retake: " + Arrays.toString(failingStudents));
        } else {
            System.out.println("No students failed the exam");
        }

        // Test with no failing students
        String[] students2 = {"ali", "harib"};
        int[] scores2 = {85, 92};
        String[] failingStudents2 = findFailingStudents(students2, scores2);
        System.out.println("\n--- Failing Students (No Failures) ---");
        if (failingStudents2.length > 0) {
            System.out.println("Students who need to retake: " + Arrays.toString(failingStudents2));
        } else {
            System.out.println("No students failed the exam");
        }
    }
}

