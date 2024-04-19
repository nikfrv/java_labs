import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        System.out.println("Enter a number: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            String str = String.format("%d", number);
            char[] c = str.toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                stack.push(c[i]);
            }
        }
        System.out.println("Reverse: " + stack);
    }
}