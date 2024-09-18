import java.lang.Math;

public class Line {
   double x1, x2, y1, y2;
   
   public Line () {
      x1 = 0;
      x2 = 0;
      y1 = 0;
      y2 = 0;
   }
   
   public Line (double x1, double y1, double x2, double y2) {
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
      
   }
   
   public double getLength() {
      double length = (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
      return Math.pow(length,0.5);

   }
   
   public boolean equalsLength(Line secondLine) {
      return this.getLength() == secondLine.getLength();
   }
}