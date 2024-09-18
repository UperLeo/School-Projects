import java.util.ArrayList;
public class OrderList {
    private int[] list;
    private int size;;

    public OrderList (int size) {
        list = new int [size];
        this.size = 0;
    }

    public void add(int item) {
        if(size == list.length) {
            System.out.println("List is full");
        }
        int temp = size;
        while (temp > 0 && list[temp - 1] > item) {
                list[temp] = list[temp - 1];
                temp--;
            } 
            list[size] = item; 
            size++;
      }

      public void remove(int item) {
        int i = 0;
        while (i < size) {
                list[i] = list[i + 1];
                i++;
            } 
            list[size] = item; 
            size--;
      }

        


    public static void main (String[] args) {
        OrderList list1 = new OrderList(2);
        list1.add(5);
        System.out.println(list1);
    }

}
