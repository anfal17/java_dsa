import java.util.*;

public class Dijkstras {

  /*
     * Shortest path from sources to vertices
     *-uses DFS

     * Algorithm
     * 1. Create a class Pair that implements Comparable interface
        - Include fields for node (n) and path
        - Implement compareTo method based on the path value

       2. Create a method dijkstra that takes an adjacency list graph and source node as parameters
        - Initialize an array dist for storing shortest distances
        - Set all distances to Integer.MAX_VALUE except for the source (dist[src] = 0)
        - Create a boolean array vis to track visited nodes, initialized to false
        - Create a priority queue pq of pairs to prioritize nodes with shorter paths

       3. Add the source node to the priority queue with path 0

       4. While the priority queue is not empty
        a. Remove the node with the shortest path from the priority queue
        b. If the node has not been visited
            i. Mark the node as visited
           ii. Iterate through all edges of the current node
              - Update the distance if a shorter path is found
              - Add the destination node to the priority queue with the updated distance

       5. Print the shortest distances from the source to all vertices
     
       */

  static class Edge {

    int src;
    int dest;
    int weight;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.weight = w;
    }
  }

  static void creategraph(ArrayList<Edge> graph[]) {
    int V = 5;

    // initializing Arraylists in graph array
    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }

    // adding edges in graph
    // for vertex 0
    graph[0].add(new Edge(0, 1, 2));

    // for vertex 1
    graph[1].add(new Edge(1, 3, 3));
    graph[1].add(new Edge(1, 2, 1));

    // for vertex 2
    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 3, 1));
    graph[2].add(new Edge(2, 4, 2));

    // for vertex 3
    graph[3].add(new Edge(3, 1, 3));
    graph[3].add(new Edge(3, 2, 1));

    // for vertex 4
    graph[4].add(new Edge(4, 2, 2));
  }

  // Define a Pair class to represent nodes and their distances
  static class Pair implements Comparable<Pair> {

    int n; // Node identifier
    int path; // Shortest path to the node

    // Constructor to initialize the Pair
    public Pair(int n, int path) {
      this.n = n;
      this.path = path;
    }

    // Compare two Pair objects based on their paths
    @Override
    public int compareTo(Pair p2) {
      return this.path - p2.path;
    }
  }

  // Dijkstra's algorithm function
  public static void dijkstra(ArrayList<Edge>[] graph, int src) {
    // Initialize an array to store the shortest distances from the source
    int[] dist = new int[graph.length];

    // Initialize distances to Infinity for all nodes except the source
    for (int i = 0; i < graph.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    // Array to track visited nodes
    boolean vis[] = new boolean[graph.length];

    // Priority queue to prioritize nodes based on their paths
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    // Add the source node to the priority queue with a path of 0
    pq.add(new Pair(src, 0));

    // Process nodes in the priority queue until it's empty
    while (!pq.isEmpty()) {
      // Remove the node with the shortest path from the priority queue
      Pair curr = pq.remove();

      // Check if the node has not been visited
      if (!vis[curr.n]) {
        // Mark the node as visited
        vis[curr.n] = true;

        // Iterate through all edges of the current node
        for (int i = 0; i < graph[curr.n].size(); i++) {
          Edge e = graph[curr.n].get(i);
          int u = e.src;
          int v = e.dest;
          int wt = e.weight;

          // Update the distance if a shorter path is found
          if (dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
            // Add the destination node to the priority queue with the updated distance
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
    }

    // Print the shortest distances from the source to all vertices
    for (int i = 0; i < dist.length; i++) {
      System.out.println(dist[i] + " ");
    }
  }

  public static void main(String[] args) {
    int V = 6;
    ArrayList<Edge>[] graph = new ArrayList[V];

    creategraph(graph);

    int src = 0;

    dijkstra(graph, src);
  }
}
