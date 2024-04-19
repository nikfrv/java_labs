import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        System.out.println("Hello, " +name+ "!");

        System.out.println("Enter quantity of numbers: ");
        int n = sc.nextInt();
        
        int[] myArray = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter your number: ");
            int x = sc.nextInt();
            myArray[i] = x;
        }
        System.out.print("Your array: ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i]+" ");
        }
        sc.close();
        
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 == 0){
                System.out.print(myArray[i]+" ");
            }  
        }
        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 != 0){
                System.out.print(myArray[i]+" ");
            }  
        }

    }
}