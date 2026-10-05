import java.util.Arrays;
import java.util.Scanner;

public class QueueManager {
    private int[] queue = new int[10];
    private int size = 0;
    private final Scanner scanner;

    public QueueManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n========== QUEUE OPERATIONS ==========");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> enqueue(InputUtil.readInt(scanner, "Enter value to enqueue: "));
                case 2 -> dequeue();
                case 3 -> peek();
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    public void enqueue(int value) {
        ensureCapacity();
        queue[size++] = value;
        System.out.println(value + " added to queue.");
    }

    public Integer dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        int value = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        System.out.println("Dequeued value: " + value);
        return value;
    }

    public Integer peek() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return null;
        }
        System.out.println("Front value: " + queue[0]);
        return queue[0];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + (i < size - 1 ? " " : ""));
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (size == queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 2);
        }
    }
}
