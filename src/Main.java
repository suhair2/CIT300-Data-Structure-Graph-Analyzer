import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayManager arrayManager = new ArrayManager(scanner);
        StackManager stackManager = new StackManager(scanner);
        QueueManager queueManager = new QueueManager(scanner);
        LinkedListManager linkedListManager = new LinkedListManager(scanner);
        SearchManager searchManager = new SearchManager(scanner);
        GraphManager graphManager = new GraphManager(scanner);
        PerformanceAnalyzer performanceAnalyzer = new PerformanceAnalyzer(scanner, searchManager);

        while (true) {
            printMainMenu();
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> arrayManager.menu();
                case 2 -> stackManager.menu();
                case 3 -> queueManager.menu();
                case 4 -> linkedListManager.menu();
                case 5 -> searchManager.menu();
                case 6 -> graphManager.menu();
                case 7 -> performanceAnalyzer.showComparison();
                case 8 -> displayAllResults(arrayManager, graphManager);
                case 9 -> {
                    System.out.println("Thank you for using Data Structure & Graph Analyzer.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please select 1-9.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=============================================");
        System.out.println("   DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("=============================================");
    }

    private static void displayAllResults(ArrayManager arrayManager, GraphManager graphManager) {
        System.out.println("\n========== CURRENT SYSTEM SUMMARY ==========");
        System.out.println("Array:");
        arrayManager.display();
        System.out.println("Graph vertices currently stored: " + graphManager.vertexCount());
        System.out.println("Use each component menu to view its complete current state.");
    }
}
