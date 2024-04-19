
import java.io.IOException;
import java.nio.file.*;
import java.util.regex.*;

/**
 * Class {@App} is the root of the class hierarchy.
 * 
 * @author Nikiforov
 */

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String targetWord = "face";
        String filePath = "C:/Users/nik-d/labs/lab2/lab2.1//filename.txt";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            int count = countOccurences(content, targetWord);
            System.out.println("The word '" + targetWord + "' occurs " + count + " times.");

            String updatedContent = removeExtraSpaces(content);
            Files.write(Paths.get(filePath), updatedContent.getBytes());

            System.out.println("Extra spaces have been removed. Please check the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Programmer: Nikiforov");

        java.time.LocalDate date = java.time.LocalDate.now();
        System.out.println("Local date is: " + date);

        java.time.LocalTime time = java.time.LocalTime.now();
        System.out.println("Local time is: " + time);

        int[] numbers = { 123, 2433, 34, 3428 };
        for (int number : numbers) {
            if (isIncreasingNumbers(number)) {
                System.out.println("First number in order: " + number);
            }
            break;
        }
    }

    public static int countOccurences(String content, String targetWord) {
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(targetWord) + "\\b", Pattern.CASE_INSENSITIVE); /**
                                                                                                                 * Без
                                                                                                                 * учета
                                                                                                                 * регистров
                                                                                                                 */
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static String removeExtraSpaces(String content) {
        return content.replaceAll("(\\p{Punct})\\s+(\\p{Punct})", "$1$2");
    }

    public static boolean isIncreasingNumbers(int number) {
        String numStr = Integer.toString(number);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}