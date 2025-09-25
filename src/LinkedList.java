import java.util.Scanner;

public class LinkedList {
    class Node {
        int data;
        Node next;
    }

    Node head;
    Node tail;
    int size;


    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid Argument");
            return;
        }
        Node newNode = new Node();
        newNode.data = val;
        if (idx == 0) {
            if (size == 0) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

        } else if (idx == size) {

            if (size == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

        } else {


            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
        size++;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public int getSize() {
        return size;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter Number of elements to insert: ");
        int n= sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("Enter index to insert at(0 to "+list.getSize()+ "): ");
            int index= sc.nextInt();

            System.out.println("Enter value to Insert: ");
            int val = sc.nextInt();

            list.addAt(index,val);
            System.out.println("Current List: ");
            list.display();
            System.out.println();

        }
        System.out.println("Final Linked List: ");
        list.display();
        System.out.println("Final Size: "+ list.getSize());
    }
}


