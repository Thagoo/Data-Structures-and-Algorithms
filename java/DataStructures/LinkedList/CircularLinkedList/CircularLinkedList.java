
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void deleteNode(int target) {
        int i = 1;
        if (head == null) {
            System.out.println("Nothing to delete");
            return;
        }
        if (target == 1) {
            if (head.next == head) {
                head = null;
                return;
            }
            head = head.next;
        } else {
            Node current = head;
            while (current.next != head) {
                if (i == target) {
                    System.out.println(current.data);
                    current = current.prev;
                    current.next = current.next.next;
                    current.next.prev = current;
                    return;
                }
                current = current.next;
                i++;
            }
            System.out.println("Null");

        }
    }

    public void display() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current.next != head) {
            System.out.print("<-" + current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);
        linkedList.display();
        linkedList.deleteNode(6);
        linkedList.display();
    }
}
