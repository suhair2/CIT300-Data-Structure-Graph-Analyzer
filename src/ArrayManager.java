import java.util.Arrays;
import java.util.Scanner;

public class ArrayManager {
    private int[] data;
    private int size;
    private final Scanner scanner;

    public ArrayManager(Scanner scanner) {
        this.scanner = scanner;
        this.data = new int[10];
        this.size = 0;
    }

    public void menu() {
        while (true) {
            System.out.println("\n========== ARRAY OPERATIONS ==========");
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
        ensureCapacity();
        data[size++] = value;
        System.out.println(value + " inserted successfully.");
    }

    public boolean delete(int value) {
        int index = indexOf(value);
        if (index == -1) {
            System.out.println("Value not found.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(value + " deleted successfully.");
        return true;
    }

    public int search(int value) {
        int index = indexOf(value);
        if (index >= 0) {
            System.out.println("Value found at index " + index + ".");
        } else {
            System.out.println("Value not found.");
        }
        return index;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + (i < size - 1 ? " " : ""));
        }
        System.out.println();
    }

    public int[] getValues() {
        return Arrays.copyOf(data, size);
    }

    public void loadSampleData() {
        data = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        size = 10;
    }

    private int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
