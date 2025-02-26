import java.util.Scanner;
public class OneZeroTriangle   {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= n; i++) {
            int start = (i % 2 == 1) ? 1 : 0; // Odd row -> 1, Even row -> 0

            for (int j = 1; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start; // Toggle between 1 and 0
            }
            System.out.println();
        }
    }
}