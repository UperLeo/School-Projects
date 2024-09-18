import java.util.Scanner;

public class Fibonacci {
    
    public static long fib(long x) {

        if (x == 0) {
            return 0;
        } else if (x ==  1) {
            return 1;
        } else {
        return fib(x-2) + fib(x-1);
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter an index for a Fibonnaci number: ");
        int x = input.nextInt();
        System.out.println("The Fibonnaci at index "+ x + " is "+ fib(x));
    }
}
