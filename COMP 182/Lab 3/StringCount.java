public class StringCount {

    public static int count (String str, char a) {

        //base case
        if (str.length() == 0) {
            return 0;

            //check if character is equal to the string at index 0, if it is equal it deletes the first character in the string and adds one
        } else if (str.charAt(0) == a) {
            return 1 + count(str.substring(1), a);
            
            //deletes the first character of the string
            } else {
                return count(str.substring(1), a);

            } 
        } 

    public static void main(String[] args) {
        String str = "Welcome";
        char a = 'e';

        int amount = count(str, a);
        System.out.println(amount);
    }
    
}
