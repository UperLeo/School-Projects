public class Rectangle {
   private int width;
   private int height;
   private int area;
   
   
   public void setDimensions (int width, int height) {
      this.width = width;
      this.height = height;
   }
   
   
   public int getArea() {
      int area;
      area = this.width * this.height;
      return (area);
   }
   
   

}