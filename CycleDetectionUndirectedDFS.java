import java.util.*;

public class CycleDetectionUndirectedDFS {
    private Map<String, List<String>> adjList;

    public CycleDetectionUndirectedDFS() {
        adjList = new HashMap<>();
    }

    // Add an undirected edge
    public void addEdge(String u, String v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // DFS utility to detect cycle
    private boolean hasCycleDFS(String current, String parent, Set<String> visited) {
        visited.add(current);

        for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasCycleDFS(neighbor, current, visited)) {
                    return true;
                }
            } else if (!neighbor.equals(parent)) {
                // Cycle found
                return true;
            }
        }

        return false;
    }

    // Public method to check cycle for disconnected graph
    public boolean containsCycle() {
        Set<String> visited = new HashSet<>();

        for (String node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycleDFS(node, null, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Print the graph
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List):");
        for (String node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CycleDetectionUndirectedDFS graph = new CycleDetectionUndirectedDFS();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        sc.nextLine();

        Set<String> vertices = new HashSet<>();
        System.out.println("Enter vertex names:");
        for (int i = 0; i < v; i++) {
            vertices.add(sc.nextLine());
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter edges (format: from to):");
        for (int i = 0; i < e; i++) {
            String u = sc.next();
            String v2 = sc.next();
            graph.addEdge(u, v2);
        }

        graph.printGraph();

        if (graph.containsCycle()) {
            System.out.println("\n⚠️ Cycle detected in the graph!");
        } else {
            System.out.println("\n✅ No cycle detected in the graph.");
        }

        sc.close();
    }
}
