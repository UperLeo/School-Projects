import java.util.Scanner;
   public class BodyMassIndex {
      public static void main(String[] args) {
         System.out.println("Hello, I am going to calculate your body mass index.");
         System.out.println("Please enter your weight in pounds.");
         int weight;
         int feet;
         int inches;
         Scanner keyboard = new Scanner(System.in);
         weight = keyboard.nextInt();
         System.out.println("Now please enter your height in feet.");
         feet = keyboard.nextInt();
         System.out.println("Now please enter your height in inches.");
         inches = keyboard.nextInt();
         //mass in this case is going to be weight converted to kilograms
         double mass = weight / 2.2;
         //converts height to inches and then to meters
         double height = ((feet * 12) + inches) * 0.0254; 
         double BMI = mass / Math.pow(height, 2);

         if (BMI >= 30) {
            System.out.println("Your BMI is " + BMI + ", you are obese.");
         } else if (BMI >= 25) {
            System.out.println("Your BMI is " + BMI + ", you are overweight.");
         } else if (BMI >= 18.5) {
            System.out.println("Your BMI is " + BMI + ", you are normal.");
         } else 
            System.out.println("Your BMI is " + BMI + ", you are underweight.");
 
      }
   }