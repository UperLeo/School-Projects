public class LineSample {
   public static void main(String[] args) {
      Line l1 = new Line (1, 2, 3, 4);
      Line l2 = new Line (1, 2, 3, 4);
      
      if (l1.equals(l2.getLength())) {
         System.out.println("The two lines are equal.");
         } else System.out.print("The two lines are not equal.");
   }
   
}