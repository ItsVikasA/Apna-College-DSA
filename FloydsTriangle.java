public class FloydsTriangle{          
    public static void main(String[] args)  {
        int rows = 5; // You can change the number of rows as per your requirement
        int number = 1;
        for (int i = 1; i <= rows; i++) { 
            // Inner loop to print numbers in each row
            for (int j = 1; j <= i; j++)  {
                System.out.print(number + " "); 
                number++; // Increment number
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}
