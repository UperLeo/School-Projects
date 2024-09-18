public class Recursion {
    
    public static double m(double i) {
        if (i == 0) {
            return 0;
        } else {
            return (i / (i+1)) + m(i-1);
        }
    }
        
    public static void main(String[] args) {
        double value = 10;
        System.out.println(m(value));
    }
}
