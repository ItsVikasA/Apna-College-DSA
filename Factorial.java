import java.util.Scanner;           
public class Factorial  {       
 public static void main(String[] args)
     {
        int fact=1;
        int number;
        Scanner Sc=new Scanner(System.in);
        System.out.println("enter the number"); 
        number=Sc.nextInt();
        for(int i=1;i<=number;i++)
        {
        fact*=i;
        }
        System.out.println("factorial of the number is "+fact);
    }
}
