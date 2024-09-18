public class Lab2_2 {
  public static void main(String[] args) {
    Integer[][] numbers = { {1, 2, 3}, {4, 4, 6} };
    Double[][] num = { {2.0, 3.6, 7.8}, {4.5, 4.7, 9.2} };
    
    System.out.println(max(numbers));
    System.out.println(max(num));
  }

  public static<E extends Comparable<E>> E max(E[][] list) {
    //Implement it
    E max = list[0][0];
    
    for(int i = 0; i < list.length; i++) {
      for(int  j = 0; j < list[i].length; j++) {
         if (list[i][j].compareTo(max) > 0) {
            max = list[i][j];
         }
      }
    }
    
    return max;
  }
}
