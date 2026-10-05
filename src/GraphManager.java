import java.util.*;

public class GraphManager {
    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();
    private final Scanner scanner;

    public GraphManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n========== GRAPH OPERATIONS ==========");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputUtil.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> addVertex(InputUtil.readNonEmptyString(scanner, "Enter vertex name: "));
                case 2 -> {
                    String from = InputUtil.readNonEmptyString(scanner, "Enter first vertex: ");
                    String to = InputUtil.readNonEmptyString(scanner, "Enter second vertex: ");
                    addEdge(from, to);
                }
                case 3 -> displayGraph();
                case 4 -> bfs(InputUtil.readNonEmptyString(scanner, "Start vertex: "));
                case 5 -> dfs(InputUtil.readNonEmptyString(scanner, "Start vertex: "));
                case 6 -> loadSampleGraph();
                case 7 -> { return; }
                default -> System.out.println("Invalid choice. Please select 1-7.");
            }
        }
    }

    public void addVertex(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }
        adjacencyList.put(vertex, new ArrayList<>());
        System.out.println("Vertex " + vertex + " added.");
    }

    public void addEdge(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("Both vertices must exist before adding an edge.");
            return;
        }
        if (!adjacencyList.get(from).contains(to)) adjacencyList.get(from).add(to);
        if (!adjacencyList.get(to).contains(from)) adjacencyList.get(to).add(from);
        System.out.println("Edge added between " + from + " and " + to + ".");
    }

    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + String.join(", ", entry.getValue()));
        }
    }

    public List<String> bfs(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return Collections.emptyList();
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;

        long begin = System.nanoTime();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            steps++;
            for (String neighbor : adjacencyList.get(current)) {
                if (visited.add(neighbor)) queue.offer(neighbor);
            }
        }
        long end = System.nanoTime();

        List<String> order = new ArrayList<>(visited);
        System.out.println("BFS Traversal: " + String.join(" -> ", order));
        System.out.println("Visited Vertices / Steps: " + steps);
        System.out.println("Execution Time: " + (end - begin) + " ns");
        return order;
    }

    public List<String> dfs(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return Collections.emptyList();
        }

        Set<String> visited = new LinkedHashSet<>();
        int[] steps = {0};
        long begin = System.nanoTime();
        dfsRecursive(start, visited, steps);
        long end = System.nanoTime();

        List<String> order = new ArrayList<>(visited);
        System.out.println("DFS Traversal: " + String.join(" -> ", order));
        System.out.println("Visited Vertices / Steps: " + steps[0]);
        System.out.println("Execution Time: " + (end - begin) + " ns");
        return order;
    }

    private void dfsRecursive(String current, Set<String> visited, int[] steps) {
        visited.add(current);
        steps[0]++;
        for (String neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, steps);
            }
        }
    }

    public void loadSampleGraph() {
        adjacencyList.clear();
        for (String v : List.of("A", "B", "C", "D", "E")) {
            adjacencyList.put(v, new ArrayList<>());
        }
        connectSilently("A", "B");
        connectSilently("A", "C");
        connectSilently("B", "D");
        connectSilently("C", "E");
        System.out.println("Sample graph loaded: A-B, A-C, B-D, C-E");
    }

    private void connectSilently(String a, String b) {
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
    }

    public int vertexCount() {
        return adjacencyList.size();
    }
}
