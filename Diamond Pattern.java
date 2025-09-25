import java.util.Scanner;                  
public class DiamondPattern   {               
    public static void main(String[] args)  {   
       Scanner scanner = new  Scanner(System.in);
        System.out.print("Enter the number of rows for the upper half: ");
        int n = scanner.nextInt();
        scanner.close();

        // Upper half of the diamond
        for (int i = 1; i <= n; i++){
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                 System.out.print(" "); 
            } 
            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
