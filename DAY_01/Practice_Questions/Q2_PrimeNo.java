import java.util.Scanner;

public class Q2_PrimeNo 
{

     public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.println("Prime numbers up to " + n + " are:");

        for (int num = 2; num <= n; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }

        sc.close();
    }

    
   
}
