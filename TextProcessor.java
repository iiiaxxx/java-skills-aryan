public class TextProcessor {


    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    //Replaces all occurrences of a specific word with a new word in a given text.

    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null || newWord == null) {
            return text;
        }
        // Using replaceAll to replace all occurrences. \b ensure whole word matching.
        return text.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        // Test with: "Java is fun and Java is powerful"
        String testSentence = "Java is fun and Java is powerful";

        // Counting words
        System.out.println("--- Word Count Test ---");
        System.out.println("Sentence: \"" + testSentence + "\"");
        System.out.println("Word count: " + countWords(testSentence));
        System.out.println("Empty string word count: " + countWords(""));
        System.out.println("Whitespace string word count: " + countWords("   \t  \n"));

        // Replace "Java" with "Programming"
        System.out.println("\n--- Word Replacement Test ---");
        String replacedText = replaceWord(testSentence, "Java", "Programming");
        System.out.println("Original: \"" + testSentence + "\"");
        System.out.println("Replaced: \"" + replacedText + "\"");


        String anotherTest = "This is a test. test test.";
        String replacedAnother = replaceWord(anotherTest, "test", "exam");
        System.out.println("\nOriginal: \"" + anotherTest + "\"");
        System.out.println("Replaced: \"" + replacedAnother + "\"");

    }
}

