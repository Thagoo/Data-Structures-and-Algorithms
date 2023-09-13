
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void updateNode(int target, int update) {
        if (head == null) {
            System.out.println("Nothing to update");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == target) {
                current.data = update;
                System.out.println("Element updated successfully");
                return;
            }
            current = current.next;
        }
        System.out.println("Element not found");

    }

    public void deleteNode(int target) {
        if (head == null) {
            System.out.println("Nothing to search");
            return;
        }
        if (head.data == target) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.next.data == target) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void searchNode(int target) {

        if (head == null) {
            System.out.println("Nothing to search");
            return;
        }
        int i = 1;
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                System.out.println("Element found at link " + i);
                return;
            }
            current = current.next;
            i++;
        }
        System.out.println("Element not found");
    }

    public void displayNode() {
        Node current = head;
        System.out.println("Linked List elements are");
        if (current == null) {
            System.out.println("Linked list is empty");
        } else {

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scan = new Scanner(System.in);
        int element;

        while (true) {
            System.out.println("\n\nLinked List Operations");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            int opt = scan.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Enter an element: ");
                    element = scan.nextInt();

                    list.addNode(element);
                    list.displayNode();
                    break;
                case 2:
                    list.displayNode();
                    System.out.print("Enter the target element: ");
                    int target = scan.nextInt();
                    System.out.print("Enter the new element : ");
                    element = scan.nextInt();
                    list.updateNode(target, element);
                    list.displayNode();
                    break;
                case 3:
                    list.displayNode();
                    System.out.print("Enter an element: ");
                    element = scan.nextInt();
                    list.deleteNode(element);
                    list.displayNode();
                    break;
                case 4:
                    list.displayNode();
                    System.out.print("Enter an element: ");
                    element = scan.nextInt();

                    list.searchNode(element);
                    list.displayNode();
                    break;
                case 5:
                    list.displayNode();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter shown options");
                    break;
            }

        }

    }

}
