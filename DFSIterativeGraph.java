import java.util.*;

public class DFSIterativeGraph {
    private Map<String, List<String>> adjList;

    public DFSIterativeGraph() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from); // remove for directed graph
    }

    // DFS using Stack (iterative)
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        System.out.print("DFS Iterative Traversal: ");
        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");

                // Push neighbors in reverse order for consistent output
                List<String> neighbors = adjList.get(current);
                Collections.reverse(neighbors); // Optional: to match recursive DFS order
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
                Collections.reverse(neighbors); // Restore original order
            }
        }
    }

    // Print adjacency list
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List):");
        for (String node : adjList.keySet()) {
            System.out.println(node + " -> " + adjList.get(node));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DFSIterativeGraph graph = new DFSIterativeGraph();

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
            String from = sc.next();
            String to = sc.next();
            graph.addEdge(from, to);
        }

        graph.printGraph();

        System.out.print("\nEnter starting vertex for DFS: ");
        String start = sc.next();
        if (vertices.contains(start)) {
            graph.dfs(start);
        } else {
            System.out.println("Start vertex not found.");
        }

        sc.close();
    }
}
