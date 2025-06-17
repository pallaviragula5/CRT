import java.util.*;

public class GraphOperations {
    private Map<String, List<String>> graph;
    private boolean isDirected;

    // Constructor
    public GraphOperations(boolean isDirected) {
        this.graph = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Add Vertex
    public void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add Edge
    public void addEdge(String from, String to) {
        addVertex(from);
        addVertex(to);
        graph.get(from).add(to);

        if (!isDirected) {
            graph.get(to).add(from);
        }
    }

    // Remove Vertex
    public void removeVertex(String vertex) {
        graph.remove(vertex);
        for (List<String> neighbors : graph.values()) {
            neighbors.remove(vertex);
        }
    }

    // Remove Edge
    public void removeEdge(String from, String to) {
        List<String> fromList = graph.get(from);
        if (fromList != null) {
            fromList.remove(to);
        }

        if (!isDirected) {
            List<String> toList = graph.get(to);
            if (toList != null) {
                toList.remove(from);
            }
        }
    }

    // Update Vertex Name
    public void updateVertex(String oldName, String newName) {
        if (!graph.containsKey(oldName)) {
            System.out.println("Vertex not found.");
            return;
        }

        List<String> neighbors = graph.remove(oldName);
        graph.put(newName, neighbors);

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            List<String> updatedList = new ArrayList<>();
            for (String neighbor : entry.getValue()) {
                if (neighbor.equals(oldName)) {
                    updatedList.add(newName);
                } else {
                    updatedList.add(neighbor);
                }
            }
            entry.setValue(updatedList);
        }
    }

    // Print Graph
    public void printGraph() {
        for (String vertex : graph.keySet()) {
            System.out.println(vertex + " -> " + graph.get(vertex));
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Is the graph directed? (true/false): ");
        boolean directed = sc.nextBoolean();
        GraphOperations g = new GraphOperations(directed);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Remove Vertex");
            System.out.println("4. Remove Edge");
            System.out.println("5. Update Vertex");
            System.out.println("6. Print Graph");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex name: ");
                    g.addVertex(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter from vertex: ");
                    String from = sc.nextLine();
                    System.out.print("Enter to vertex: ");
                    String to = sc.nextLine();
                    g.addEdge(from, to);
                    break;
                case 3:
                    System.out.print("Enter vertex to remove: ");
                    g.removeVertex(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter from vertex: ");
                    String fromEdge = sc.nextLine();
                    System.out.print("Enter to vertex: ");
                    String toEdge = sc.nextLine();
                    g.removeEdge(fromEdge, toEdge);
                    break;
                case 5:
                    System.out.print("Enter old vertex name: ");
                    String oldV = sc.nextLine();
                    System.out.print("Enter new vertex name: ");
                    String newV = sc.nextLine();
                    g.updateVertex(oldV, newV);
                    break;
                case 6:
                    g.printGraph();
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
