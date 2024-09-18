public class GenericStack {
    int[] list; 
    int top;

    public GenericStack() {
        int[] list = new int[];
        int top = 0;
    }

    public int getSize() {
        return list.length();
    }

    public int peek() {
        return list[list.length()-1] ;
    }

    public int pop() {
        top--;
        return list [top];
    }

    public void push(int item) {
        list[top] = item;
        top++;
    }

    public static void main(String[] args) {
        GenericStack<Integer> myStack = new GenericStack<>();
        myStack.push(10);
        myStack.push(15);
        System.out.println(myStack.top);
    }
}
