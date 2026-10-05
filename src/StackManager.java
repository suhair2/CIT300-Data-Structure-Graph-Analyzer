import java.util.Arrays;
import java.util.Scanner;

public class StackManager {
    private int[] stack = new int[10];
    private int top = -1;
    private final Scanner scanner;

    public StackManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n========== STACK OPERATIONS ==========");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> push(InputUtil.readInt(scanner, "Enter value to push: "));
                case 2 -> pop();
                case 3 -> peek();
                case 4 -> display();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    public void push(int value) {
        ensureCapacity();
        stack[++top] = value;
        System.out.println(value + " pushed into stack.");
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        int value = stack[top--];
        System.out.println("Popped value: " + value);
        return value;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        System.out.println("Top value: " + stack[top]);
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void ensureCapacity() {
        if (top + 1 == stack.length) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
    }
}
