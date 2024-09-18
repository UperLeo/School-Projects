import java.util.Scanner;

public class Assignment3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a decimal integer: ");
    int decimal = input.nextInt();
    System.out.println(decimal + " is hex " + dec2Hex(decimal));
  }  

 //Recursive method to calculate decimal to hex number

 public static String dec2Hex(int value) {
    //ToDo: Complete the method
    //base case
    if(value == 0){
      return "";
    }
    //calculates remainder
    int leftOver = value % 16;
    //converts leftover to hex character value
    char charHex = dec2HexChar(leftOver);
    //recursive call, gets quotient then finds remainder, then keeps running the method until the value reaches the base case, then goes backwards to return the string
      return dec2Hex(value / 16) + charHex;
  }
  // returns a hex character for its equivalent decimal number
  public static char dec2HexChar(int value) {
    

        if (value >= 10 && value <=15)
            //ToDo: complete the method
            //returns the character corresponding to the value
            return (char)('A' + (value -10));
        else 
           //ToDo: complete the method
           return (char)('0' + value);
  }
}