import java.util.*;

public class SmallGraph {
    private Map<String, List<String>> graph;

    public SmallGraph() {
        graph = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());

        graph.get(from).add(to);
        graph.get(to).add(from); // Remove this line if the graph is directed
    }

    // Print graph
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List):");
        for (String node : graph.keySet()) {
            System.out.println(node + " -> " + graph.get(node));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmallGraph g = new SmallGraph();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter vertex names:");
        Set<String> vertices = new HashSet<>();
        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + (i + 1) + ": ");
            vertices.add(sc.nextLine());
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter edges (format: from to):");
        for (int i = 0; i < e; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            String from = sc.next();
            String to = sc.next();
            g.addEdge(from, to);
        }

        g.printGraph();
        sc.close();
    }
}
