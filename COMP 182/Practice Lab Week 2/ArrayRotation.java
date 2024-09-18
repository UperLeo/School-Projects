import java.util.Scanner;

public class ArrayRotation {
   int arr[];
   int x;
   
   public void leftRotate(int arr[], int y, int x){
      for (int i = 0; i < y; i++)
         leftRotate1(arr, x);
   }
   
   public void leftRotate1(int arr[], int x){
      int i, temp;
      temp  = arr[0];
      for (i = 0; i < x - 1; i++)
         arr[i] = arr[i+1];
         arr[i] = temp;
      
   }
   
   public void printArray(int arr[], int x) {
      for (int i = 0; i < x; i++);
      System.out.println(arr[x] + "");
   }

   public static void main(String[] args) {
      int rotUnits;
      int x;
      ArrayRotation rotate = new ArrayRotation();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the number of elements in the array");
      x = keyboard.nextInt();
      int array[] = new int[x];
      System.out.println("Enter the elements of the array");
      for (int i = 0; i < x; i++) {
      array[i] = keyboard.nextInt();
      }
      System.out.println("Now please select the amount of units you want to rotate the array left");
      rotUnits = keyboard.nextInt();
      rotate.leftRotate(array, rotUnits , x);
      rotate.printArray(array, x);
   }
}