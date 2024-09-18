public class Lab2Template {
  public static void main(String[] args) {
    Octagon a1 = new Octagon(5);
    System.out.println("Area is " + a1.getArea());
    System.out.println("Perimeter is " + a1.getPerimeter());

    Octagon a2 = new Octagon(6);
   
    System.out.println("Compare the octagons " + a1.compareTo(a2));
  }
}

class Octagon extends GeometricObject
    implements Comparable<Octagon> {
  private double side;
  
  public double getSide() {
    return side;
  }

  public void setSide(double side) {
    // Implement it
    //checks to make sure side length is positive
    if(side < 0) {
      System.out.print("Error: Side length must be positive");
    } this.side = side;
   
  }

  /** Construct a Octagon with the default side */
  public Octagon () {
    // Implement it
    this.side = 1;
   //default would be equal to 1 not 0 because side length must be positive
  }
  
  /** Construct a Octagon with the specified side */
  public Octagon (double side) {
    // Implement it
    this.side = side;
    
  }

 
  public double getArea() {
    // Implement it
    //finds area
    return (2 + 4 / Math.sqrt(2)) * side * side;
    
  }

 
  public double getPerimeter() {
    // Implement it
    //method for finding perimeter
    return 8 * side;
  }

  @Override
  public int compareTo(Octagon obj) {
    //Implement it
    //compares areas
    if (this.getArea() > obj.getArea()){
      return 1; 
     } else if (this.getArea() < obj.getArea()) {
         return -1;
       } return 0;
    
  }

  
}
