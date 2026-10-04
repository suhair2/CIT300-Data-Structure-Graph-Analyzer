import java.util.Scanner;

public class PerformanceAnalyzer {
    private final Scanner scanner;
    private final SearchManager searchManager;

    public PerformanceAnalyzer(Scanner scanner, SearchManager searchManager) {
        this.scanner = scanner;
        this.searchManager = searchManager;
    }

    public void showComparison() {
        int n = InputUtil.readPositiveInt(scanner, "Enter input size (example 10000): ");
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = i;

        int target = InputUtil.readInt(scanner, "Enter target between 0 and " + (n - 1) + ": ");

        SearchManager.SearchResult linear = searchManager.linearSearch(data, target);
        SearchManager.SearchResult binary = searchManager.binarySearch(data, target);

        System.out.println("\n==============================================");
        System.out.println("           PERFORMANCE COMPARISON");
        System.out.println("==============================================");
        System.out.printf("%-18s %-12s %-15s%n", "Algorithm", "Steps", "Time(ns)");
        System.out.println("----------------------------------------------");
        System.out.printf("%-18s %-12d %-15d%n", "Linear Search", linear.steps, linear.timeNs);
        System.out.printf("%-18s %-12d %-15d%n", "Binary Search", binary.steps, binary.timeNs);
        System.out.println("----------------------------------------------");
        System.out.println("Linear Search Complexity : O(n)");
        System.out.println("Binary Search Complexity : O(log n)");
        System.out.println("Note: execution time can vary between runs.");
    }
}
