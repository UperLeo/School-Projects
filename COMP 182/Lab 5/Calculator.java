//import the scanner for user input
import java.util.Scanner;

public class Calculator {
    
    public Calculator() {
        //constructor
    }
    
    public static int value(char val) {
        //checks if character is equal to an operator and gives the operator a value based on how important it is in order of operations
        if(val == '^') {
            return 1000;
        } else if(val == '*' || val == '/' ) {
            return 100;
        } else if(val == '+' || val == '-') {
            return 10;
        } else {
        //this means that the character is an operand 
            return -10;
        }
    }
    

    public static String postfix(String convert) {
        //create a stack to put the operators in
        GenericStack<Character> postStack = new GenericStack<>();
        //create a string builder in order to build a string for the postfix notation
        StringBuilder postFixNot = new StringBuilder();
        //create a stack specifically for parentheses to check if they match
        GenericStack<Character> braceCheck = new GenericStack<>();
        //create a loop to traverse the users expression
        for(int i = 0; i < convert.length(); i++) {
            //define a variable val that shows the char at index i
            char val = convert.charAt(i);
            //checks to see if char is an operand and then adds it to the string postFixNot
            if(val == ' ') {
                continue;
            }
            if(val != '(' && val != ')' && val != '^' && val != '*' && val != '/' && val != '+' && val != '-') {
                postFixNot.append(val);
            
            } else if(val == '(') {
            //if val is an open brace then it gets added to both stacks
                postStack.push(val);
                braceCheck.push(val);

            } else if(val == ')') {
                //if val is a closed brace then everything inbetween the braces are popped and added to the string builder
                while (!postStack.isEmpty() && postStack.peek() != '(') {
                    postFixNot.append(postStack.pop());
                }
                if(!braceCheck.isEmpty() && braceCheck.peek() == '(') {
                //if the braceCheck stack is not empty and has an open brace at the top then it is popped out of both stacks
                    postStack.pop();
                    braceCheck.pop();
                }  else {
                    //otherwise there is an error
                    System.out.println("Parentheses are not matched");
                    return null;
                }
            
            //checks if the char is an operand
            } else if (val == '^' || val == '*' || val == '/' || val == '+' || val == '-') {
                while (!postStack.isEmpty() && (value(val) <= value(postStack.peek()))) {
                    //checks if val is equal to or greater than the top of the stack if its not empty
                    //if it is greater than or equal to, it gets added to the string
                    postFixNot.append(postStack.pop());
                }
                //if val is less than the peek or if stack empty than operand gets pushed onto the stack
                postStack.push(val);
            } 
            
        }             
        while(!postStack.isEmpty()) {
            //goes doen the stack and adds it to the string 
            postFixNot.append(postStack.pop());
        }
        if(!braceCheck.isEmpty()) {
            //if the braceCheck stack is not empty after the for loop that means there is an extra brace that should not be there
            System.out.println("Parentheses are not matched");
            return null;
        }
        //returns the user input in postfix notation
        return postFixNot.toString();
    }

    public static int calculation(String a) {
        //create new stack in order to evaluate the expression
        GenericStack<Integer> evaluation =  new GenericStack<>();
        //declare two variables because the operators operate on two operands at a time 
        int b = 0;
        int c = 0;
        //create new loop to traverse expression
        for(int i = 0; i < a.length(); i++) {
            char val = a.charAt(i);
            //checks if char is a digit, if so it gets added to the stack
            if(val >= '0' && val <= '9') {
                evaluation.push((val - '0'));
            } else {
                //otherwise the top of the stack pops the top two digits so it can be operated on
                b = evaluation.pop();
                c = evaluation.pop();

                //checks which operator is in use then adds the evaluated digits to the stack
                if(val == '+') {
                    evaluation.push(b + c);
                } else if(val == '-') {
                    evaluation.push(c - b);
                } else if(val == '*') {
                    evaluation.push(b * c);
                } else if(val == '/') {
                    evaluation.push(c / b);
                } else if(val == '^') {
                    evaluation.push((int) Math.pow(c,b));
                }
            }
        }
        //returns the top of the stack which will contain the fully evalluated expression
        return evaluation.peek();
    }
    

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Expression:");
        String express = keyboard.nextLine();
        String post = postfix(express); 
        if (post != null) {
            System.out.println(post);
            int output = calculation(post);
            System.out.println(output);
        }

    }
}
