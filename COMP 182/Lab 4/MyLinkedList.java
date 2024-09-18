public class MyLinkedList<E> implements MyList<E> {
    protected Node<E> head, tail;
    protected int size = 0; // Number of elements in the list
    
    /** Create an empty list */
    public MyLinkedList() {
      E[] list;
    }
  
    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
      // Implement it
      // E[] list = new myList[size];
      for(int i = 0; i < objects.length; i++) {
        addLast(objects[i]);
      }
    }
  
    /** Return the head element in the list */
    public E getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }
  
    /** Return the last element in the list */
    public E getLast() {
      // Implement it
      // checks if list is empty
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }
  
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
	  //  ---  Implement it	
       // Create a new node
       Node<E> first = new Node<>(e);
       // link the new node with the head
       first.element = e;
       first.next = head;
       // head points to the new node
       head = first;
       // Increase list size
      //list = list.length + 1;
      size++;
       // the new node is the only node in list
        if(tail == null) {
          tail = head;
        }
    }
  
    /** Add an element to the end of the list */
    public void addLast(E e) {
	  // --- Implement it	
        // Create a new for element e
        Node<E> last = new Node<>(e);
         // The new node is the only node in list
        if(tail == null) {
          head = tail = new Node<>(e);
        } else {
         // Link the new with the last node
         tail.next = last;
         tail = last;
        }
         // tail now points to the last node
      
  
         // Increase size
         size++;

    }
  
    @Override /** Add a new element at the specified index 
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
      // Implement it
      //checks if element is being added to the front of the list
      if(index == 0) {
        addFirst(e);
      //checks if element is being added to the end of the list 
      } else if(index == size) {
        addLast(e);
      } else {
      //creates new node and has it equal to the head
      Node<E> current;
      current = head;
      //loops through list until it reaches desired index
      for (int i = 1; i < index; i++) {
        current = current.next;
      } 
      //creates new node with element e
      Node<E> newNode = new Node<>(e); 
      //the new node next is going to equal the current next
      newNode.next = current.next;
      //the current next is going to point to the new node
      current.next = newNode;
      //increase size
      size++;
    }
    }
  
    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
      // Implement it
      //checks if list is empty
      if (size == 0) {
        return null;
      } else {
        //temp node is equal to head
        Node<E> temp = head;
        //head points towards head next 
        head = head.next;
        //decrease size of list since we are removing
        size--;

        if(head == null) {
          tail = null;
        } 
        return temp.element;
      }

    }
  
    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
      // Implement it
      // checks if there is something in the list
      if (size == 0) {
        return null;
      //checks if there is more than one item in the list, if not it sets size to 0
      } else if(size == 1) {
        Node<E> temp = head;
        head = null;
        tail = null;
        size = 0;
        return temp.element;
      //loops through list until tail is reached
      } else {
        Node<E> current = head;
        for(int i = 0; i < size - 2; i++) {
          current = current.next;
        }
      //creates temp node thats equal to tail and have the tail point to the current which is of the index before the tail
        Node<E> temp = tail;
        tail = current;
        tail.next = null;
      //decrease size
        size--;

        return temp.element;
      }
    }
  
    @Override /** Remove the element at the specified position in this 
     *  list. Return the element that was removed from the list. */
    public E remove(int index) {   
      // Implement it
      //checks all possible scenarios in order to remove an item at a specified index
      if(size == 0) {
        return null;
      } else if(index > size) {
        return null;
      } else if(index == 0) {
        return removeFirst();
      } else if(index == size) {
        return removeLast(); 
      } else {
      //create new node and loops until it reaches the element that needs to be removed
      Node<E> current, previous;
      current = head;
      previous = null;
      for (int i = 1; i < index + 1; i++) {
      //changes the way that the nodes are linked so that the previous node links to the node after the one that we want to remove 
        previous = current;
        current = current.next;
      } 
      previous.next = current.next;
      // decrease size
      size--;
      return current.element;
    }
    }
  
    @Override /** Override toString() to return elements in the list */
    public String toString() {
      StringBuilder result = new StringBuilder("[");
  
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }
  
      return result.toString();
    }
  
    @Override /** Clear the list */
    public void clear() {
      // Implement it
      // if there is no head and size equals 0, then it clears all items
      head = null;
      size = 0;
    }
  
    @Override /** Return true if this list contains the element e */
    public boolean contains(Object e) {
      // Implement it 
      Node<E> current = head;
      while (current != null) {
      if(e == current) {
      return true;
      } else {
        current = current.next;
        return false;
      }
      }
      return false;

    }
  
    @Override /** Return the element at the specified index */
    public E get(int index) {
      // Implement it 
      //goes through the list until it reaches the specified index and then returns the element at the index
      Node<E> current = head;
      for(int i = 0; i < index; i++){
      current = current.next; 
      } 
      return current.element;
      }
  
    @Override /** Return the index of the first matching element in 
     *  this list. Return -1 if no match. */
    public int indexOf(Object e) {
      // Implement it
      //traverses the list until the desired element equals the current element and then it returns the index
      Node<E> current = head;
      int index = 0;
      while (current != null) {
      if(e.equals(current.element)) {
        return index;
      }
      current = current.next; 
      index++;
      }
      return -1;
    }
  
    @Override /** Return the index of the last matching element in 
     *  this list. Return -1 if no match. */
    public int lastIndexOf(E e) {
      Node<E> current = head;
      int temp=0;
      //traverse list until the element is equal to the current and then stores it in a temp variable at what index it is at, and then returns the last instance of the element
      for(int i = 0; i < size; i++) {
        if (e.equals(current.element))temp = i;
        current = current.next;
      }
      return temp;
    }
  
    @Override /** Replace the element at the specified position 
     *  in this list with the specified element. */
    public E set(int index, E e) {
      // Implement it
      //traverses list until desired index
      Node<E> current = head;
      for(int i = 0; i < index; i++) {
      //points new current to current next
        current = current.next; 
      }
        return current.element;
        
      }
  
      
  
    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
      return new LinkedListIterator();
    }
    
    private class LinkedListIterator 
        implements java.util.Iterator<E> {
      private Node<E> current = head; // Current index 
      
      @Override
      public boolean hasNext() {
        return (current != null);
      }
  
      @Override
      public E next() {
        E e = current.element;
        current = current.next;
        return e;
      }
  
      @Override
      public void remove() {
        // You may not implement it
      }
    }
    
    protected static class Node<E> {
      E element;
      Node<E> next;
  
      public Node(E element) {
        this.element = element;
      }
    }
    
    @Override /** Return the number of elements in this list */
    public int size() {
      return size;
    }
  }