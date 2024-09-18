import java.util.*;

import javax.swing.tree.TreeNode;
public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    /** Create a default binary tree */
    public BST() {
    }

    /** Create a binary tree from an array of objects */
    public BST(E[] objects) {
      for (int i = 0; i < objects.length; i++)
        insert(objects[i]);
    }
    //added this to avoid error
    @Override
    public boolean delete(E e) {
      return false;
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
      TreeNode<E> current = root; // Start from the root

     //Implement it
     //traverse tree until the current reaches the end of the tree or finds the element that is being searched for
      while (current != null && e.compareTo(current.element) != 0) {
      //if the current element is greater than the searched element, we move the current to the left and continue with the loop
        if (e.compareTo(current.element) < 0) {
          current = current.left;
      //otherwise if the current element is less than the searched element, the current moves toward the right and then the loop continues
        } else if (e.compareTo(current.element) > 0) {
          current = current.right;
        }
      //once loop finishes it checks if element is found and returns true
      } if(current != null && e.compareTo(current.element) == 0) {
        return true;
      } else {
        return false;  //element is not found
      }
    }

    @Override
    /** Insert element o into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
      // Implement the method
      TreeNode<E> current;
      if (root == null)
             // Create a new root
          root = new TreeNode<>(e);
      else {
        // Locate the parent node
        TreeNode<E> parent = current = root;
        // Duplicate node not inserted
        //traverse tree
        while(current != null) {
        //if element is less than the current element
          if(e.compareTo(current.element) < 0) {
          //parent points to the current and then the current moves to the left
            parent = current;
            current = current.left;
          //if elementis less than the current
          } else if (e.compareTo(current.element) > 0) {
          //parent becomes the current and the current moves right
            parent = current;
            current = current.right;
          } else {
          //otherwise element is equal to the current so return false because element was not inserted
            return false;
          }
        }
        // Create the new node and attach it to the parent node
        //if element is less than parent, then a new node is created as a child to the left of the parant
        if(e.compareTo(parent.element) < 0) {
          parent.left = new TreeNode<>(e);         
        } else {
        //otherwise a new node is created as a child to the right of the parent
          parent.right = new TreeNode<>(e); 
        }
      }

      size++;
      return true; // Element inserted
    }

    protected TreeNode<E> createNewNode(E e) {
      return new TreeNode<E>(e);
    }

    @Override
    /** Inorder traversal from the root*/
    public void inorder() {
      inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
      if (root == null)
        return;
      inorder(root.left);
      System.out.print(root.element + " ");
      inorder(root.right);
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
      postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
      if (root == null)
        return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.element + " ");
    }

    @Override
    /** Preorder traversal from the root */
    public void preorder() {
      preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
      if (root == null)
        return;
      System.out.print(root.element + " ");
      preorder(root.left);
      preorder(root.right);
    }

    /**
     * This inner class is static, because it does not access any instance
     * members defined in its outer class
     */
    public static class TreeNode<E extends Comparable<E>> {
      protected E element;
      protected TreeNode<E> left;
      protected TreeNode<E> right;

      public TreeNode(E e) {
        element = e;
      }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
      return size;
    }

    /** Returns the root of the tree */
    public TreeNode<E> getRoot() {
      return root;
    }

   

    

    @Override
    /** Obtain an iterator. Use inorder. */
    public java.util.Iterator<E> iterator() {
      return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
      // Store the elements in a list
      private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
      private int current = 0; // Point to the current element in list

      public InorderIterator() {
        inorder(); // Traverse binary tree and store elements in list
      }

      /** Inorder traversal from the root */
      private void inorder() {
        inorder(root);
      }

      /** Inorder traversal from a subtree */
      private void inorder(TreeNode<E> root) {
        if (root == null)
          return;
        inorder(root.left);
        list.add(root.element);
        inorder(root.right);
      }

      @Override
      /** More elements for traversing? */
      public boolean hasNext() {
        if (current < list.size())
          return true;

        return false;
      }

      @Override
      /** Get the current element and move to the next */
      public E next() {
        return list.get(current++);
      }

      @Override
      /** Remove the current element */
      public void remove() {
        delete(list.get(current)); // Delete the current element
        list.clear(); // Clear the list
        inorder(); // Rebuild the list
      }
    }

    /** Remove all elements from the tree */
    public void clear() {
      root = null;
      size = 0;
    }
    
    /** Inorder traversal from the root*/
    public void nonRecursivePreorder() {
      java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
      Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

      // implement the method
      //if root is not null then the root gets added to the stack
      //preorder must start with root
      if(root != null) {
        stack.push(root);
      }
      //while the stack is not empty, a new node current is created which is equal to the top of the stack and gets popped
      while (!stack.isEmpty()) {
        TreeNode<E> current = stack.pop();
        //the top of the stack gets added to the array list which is the root first4
        list.add(current);

        //if the right of the current element is not null add the right of the of the current element because stacks are LIFO
        //must do right first than left so when added to the list 
        if(current.right != null) {
          stack.push(current.right);
        }
        //if the left of the current element is not null and add the left of the current element to the stack
        if(current.left != null) {
          stack.push(current.left);
        }
      }
      //print out each element that was added to the list
      for (int i = 0; i < list.size(); i++)
        System.out.print((list.get(i)).element + " ");
    }

    /** Inorder traversal from the root*/
    public void nonRecursiveInorder() {
      java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
      Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

      // implement the method
      //inorder starts from the left subtrees and then goes to the root and then down to the right nodes 
      //creates new node and has it equal to the root 
      TreeNode<E> current = root;
      //creates loop if current is not equal to null and the stack is not empty
      while(current != null || !stack.isEmpty()) {
        //another loop which continues if current is not equal to null
        while(current != null) {
        //adds the current to the stack
        stack.push(current);
        //moves current left
        current = current.left;
        }
        //the curent equals the top of stack and has it popped, adds if the list, then the current moves right
        current = stack.pop();
        list.add(current);
        current = current.right;
      }
      //prints out every item on list
      for (int i = 0; i < list.size(); i++)
        System.out.print((list.get(i)).element + " ");
    }
  }
