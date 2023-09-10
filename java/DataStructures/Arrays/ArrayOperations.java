import java.util.Scanner;

public class ArrayOperations {
    private static int[] array = new int[10];
    private static int size;
    private static Scanner scan = new Scanner(System.in);

    public static void insertion() {

        System.out.print("Enter size of array: ");
        size = scan.nextInt();
        System.out.print("\nEnter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Array after initialization");
        display();
    }

    public static void update() {
        if (array.length <= 0) {
            insertion();
        }
        System.out.println("Array elements");
        display();
        System.out.print("Enter the index of element to update: ");
        int index = scan.nextInt();
        System.out.print("Enter the new element: ");
        int element = scan.nextInt();
        array[index] = element;

        System.out.println("Array afer updating");
        display();
    }

    public static void delete() {
        if (array.length <= 0) {
            insertion();
        }
        System.out.println("Array elements");
        display();
        System.out.print("Enter the index of element to delete: ");
        int index = scan.nextInt();
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j++] = array[i];
        }
        array = newArray;
        size--;
        System.out.println("Array after deleting");
        display();
    }

    public static void search() {
        if (array.length <= 0) {
            insertion();
        }
        display();
        System.out.print("Enter element to search: ");
        int element = scan.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("Element found at index: " + i);
                break;
            }
        }
    }

    public static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int opt;

        while (true) {
            System.out.println("\n\nArray Operations");
            System.out.println("1. Insertion");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Searching");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    insertion();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter shown options");
                    break;
            }
        }

    }
}