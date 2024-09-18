import java.util.*;

import java.util.Scanner;

public class Lab6 {
  public static void main(String[] args) {
    BST<Integer> tree1 = new BST<Integer>();

    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter 10 integers and store them in the tree
    System.out.println("print 10 integers:");
    for (int i = 0; i < 10; i++) {
      tree1.insert(input.nextInt());
    }
    
    System.out.print("Recursive inorder: ");tree1.preorder();System.out.println();
    System.out.print("Non-Recursive inorder: ");tree1.nonRecursivePreorder();System.out.println();
    
    BST<String> tree = new BST<>();
    tree.insert("George");
    tree.insert("Michael");
    tree.insert("Tom");
    tree.insert("Adam");
    tree.insert("Jones");
    tree.insert("Peter");
    // tree.insert("John");
    tree.insert("Daniel");

    System.out.print("Recursive Preorder: "); tree.preorder(); System.out.println();
    System.out.print("Non-Recursive Preorder: ");tree.nonRecursivePreorder(); System.out.println();

    System.out.print("Recursive inorder: "); tree.inorder(); System.out.println();
    System.out.print("Non-Recursive inorder: ");tree.nonRecursiveInorder();
  }

  
}
