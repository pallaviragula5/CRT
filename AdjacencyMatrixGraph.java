import java.util.Scanner;

public class AdjacencyMatrixGraph {
    private int[][] adjMatrix;
    private int vertices;

    // Constructor
    public AdjacencyMatrixGraph(int v) {
        this.vertices = v;
        adjMatrix = new int[v][v]; // initialize all entries to 0
    }

    // Method to add an edge (undirected)
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Remove this line for directed graph
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix of the Graph:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(v);

        System.out.println("Enter edges (format: u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v1 = sc.nextInt();
            graph.addEdge(u, v1);
        }

        graph.printGraph();
        sc.close();
    }
}
