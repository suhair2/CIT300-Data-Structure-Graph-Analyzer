import java.util.Arrays;
import java.util.Scanner;

public class SearchManager {
    private final Scanner scanner;

    public SearchManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n======== SEARCHING OPERATIONS ========");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary Search");
            System.out.println("4. Return to Main Menu");
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> runLinearSearch();
                case 2 -> runBinarySearch();
                case 3 -> compareSearches();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }

    private int[] readArray() {
        int n = InputUtil.readPositiveInt(scanner, "How many numbers? ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = InputUtil.readInt(scanner, "Enter value " + (i + 1) + ": ");
        }
        return values;
    }

    private void runLinearSearch() {
        int[] values = readArray();
        int target = InputUtil.readInt(scanner, "Enter value to search: ");
        SearchResult result = linearSearch(values, target);
        printResult("Linear Search", result);
    }

    private void runBinarySearch() {
        int[] values = readArray();
        Arrays.sort(values);
        System.out.println("Sorted array: " + Arrays.toString(values));
        int target = InputUtil.readInt(scanner, "Enter value to search: ");
        SearchResult result = binarySearch(values, target);
        printResult("Binary Search", result);
    }

    private void compareSearches() {
        int n = InputUtil.readPositiveInt(scanner, "Enter data size for comparison (example 1000): ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = i * 2;

        int target = InputUtil.readInt(scanner, "Enter an even target value to search: ");

        SearchResult linear = linearSearch(values, target);
        SearchResult binary = binarySearch(values, target);

        System.out.println("\n============= SEARCH COMPARISON =============");
        System.out.printf("%-18s %-10s %-15s %-12s%n", "Algorithm", "Found", "Steps", "Time(ns)");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-18s %-10s %-15d %-12d%n",
                "Linear Search", linear.index >= 0, linear.steps, linear.timeNs);
        System.out.printf("%-18s %-10s %-15d %-12d%n",
                "Binary Search", binary.index >= 0, binary.steps, binary.timeNs);
        System.out.println("\nComplexity:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n) on sorted data");
    }

    public SearchResult linearSearch(int[] values, int target) {
        int steps = 0;
        long start = System.nanoTime();
        int index = -1;
        for (int i = 0; i < values.length; i++) {
            steps++;
            if (values[i] == target) {
                index = i;
                break;
            }
        }
        long end = System.nanoTime();
        return new SearchResult(index, steps, end - start);
    }

    public SearchResult binarySearch(int[] sortedValues, int target) {
        int low = 0, high = sortedValues.length - 1, steps = 0, index = -1;
        long start = System.nanoTime();

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedValues[mid] == target) {
                index = mid;
                break;
            } else if (sortedValues[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long end = System.nanoTime();
        return new SearchResult(index, steps, end - start);
    }

    private void printResult(String name, SearchResult result) {
        System.out.println("\n" + name);
        System.out.println("Found: " + (result.index >= 0 ? "Yes, index " + result.index : "No"));
        System.out.println("Steps: " + result.steps);
        System.out.println("Execution Time: " + result.timeNs + " ns");
    }

    public static class SearchResult {
        public final int index;
        public final int steps;
        public final long timeNs;

        public SearchResult(int index, int steps, long timeNs) {
            this.index = index;
            this.steps = steps;
            this.timeNs = timeNs;
        }
    }
}
