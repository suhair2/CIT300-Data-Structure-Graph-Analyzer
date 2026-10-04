import java.util.Scanner;

public class LinkedListManager {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private final Scanner scanner;

    public LinkedListManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n======= LINKED LIST OPERATIONS =======");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> insert(InputUtil.readInt(scanner, "Enter value to insert: "));
                case 2 -> delete(InputUtil.readInt(scanner, "Enter value to delete: "));
                case 3 -> search(InputUtil.readInt(scanner, "Enter value to search: "));
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        System.out.println(value + " inserted into linked list.");
    }

    public boolean delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return false;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted.");
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return false;
        }

        current.next = current.next.next;
        System.out.println(value + " deleted.");
        return true;
    }

    public boolean search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position " + position + ".");
                return true;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value not found.");
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
