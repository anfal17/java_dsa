import java.util.*;

public class TopologicalSortBFS {

  /*
   * Topological Sort is a way to arrange vertices in a Directed Acyclic Graph (DAG) in a linear order.
   * In this order, if there is a directed edge from vertex u to vertex v, then u comes before v.
   *
   * We use a method called Topological Sort Using BFS, which involves counting in-degrees and out-degrees.
   * A key fact is that in a DAG, there is at least one vertex with no incoming edges (in-degree 0)
   * and one vertex with no outgoing edges (out-degree 0).
   *
   step-by-step algorithm:
   * 1. Count how many incoming edges each vertex has (in-degrees) and store these counts.
   * 2. Start with vertices that have no incoming edges (in-degree 0), and put them in a queue.
   * 3. While the queue is not empty:
   *    a. Take a vertex from the queue, print it.
   *    b. Reduce the in-degree of its neighbors.
   *    c. If a neighbor's in-degree becomes 0, put it in the queue.
   * 4. Repeat until the queue is empty.
   
   To calculate in-degrees:
   * - Go through each vertex in the graph.
   * - Check if there are edges going to other vertices.
   * - Increase the in-degree count of the destination vertex for each edge.
   */

  static class Edge {

    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  static void creategraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 0));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));

    graph[4].add(new Edge(4, 3));
  }

  // Calculate the in-degrees of all vertices in a directed graph
  public static void calculateIndeg(ArrayList<Edge>[] graph, int indeg[]) {
    // Loop through all vertices in the graph
    for (int i = 0; i < graph.length; i++) {
      // For each vertex, iterate through its outgoing edges
      for (int j = 0; j < graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        // Increment the in-degree of the destination vertex
        indeg[e.dest]++;
      }
    }
  }

  // Perform Topological Sorting using Kahn's algorithm
  // Time complexity: O(V + E)
  public static void topSort(ArrayList<Edge>[] graph) {
    // Array to store in-degrees of vertices
    int[] indeg = new int[graph.length];

    // Queue to store vertices with in-degree 0
    Queue<Integer> q = new LinkedList<>();

    // Initialize in-degrees and add vertices with in-degree 0 to the queue
    for (int i = 0; i < indeg.length; i++) {
      if (indeg[i] == 0) {
        q.add(i);
      }
    }

    // Process vertices in topological order
    while (!q.isEmpty()) {
      // Remove a vertex with in-degree 0 from the queue
      int curr = q.remove();
      System.out.print(curr + " ");

      // Iterate through the outgoing edges of the current vertex
      for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        // Decrement the in-degree of the destination vertex
        indeg[e.dest]--;

        // If the in-degree becomes 0, add the destination vertex to the queue
        if (indeg[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }
  }

  public static void main(String[] args) {}
}
