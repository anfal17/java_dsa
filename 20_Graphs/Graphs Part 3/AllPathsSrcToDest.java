import java.util.*;

public class AllPathsSrcToDest {

  /*
   * Finds All Possible Paths from Source to Destination using Depth-First Search (DFS).
   *
   * Algorithm:
   * 1. Start from the source node (src).
   * 2. For each neighbor of the source node:
   *    a. Call DFS on the neighbor to explore paths.
   *    b. If the neighbor is the destination (dest), print the current path and return.
   * 3. Backtrack to explore other possible paths by trying different neighbors.
   *
   * The algorithm effectively explores the graph using DFS, checking all possible paths
   * from the source to the destination. When a path from src to dest is found, it's printed,
   * and the algorithm continues exploring other paths.
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

  //O(V^2) Worst Case
  public static void printallPaths(
    ArrayList<Edge>[] graph,
    int src,
    int dest,
    String path
  ) {
    // Base case: If source and destination are the same, print the path and return
    if (src == dest) {
      System.out.println(path + dest);
      return;
    }

    // Recursive exploration of all edges from the source node
    for (int i = 0; i < graph[src].size(); i++) {
      Edge e = graph[src].get(i);

      // Recursive call to explore paths from the destination of the current edge
      // Concatenate the current source node to the path
      printallPaths(graph, e.dest, dest, path + src);
    }
  }

  public static void main(String[] args) {
    int V = 6;
    ArrayList<Edge>[] graph = new ArrayList[V];

    creategraph(graph);

    int src = 0, target = 4;

    printallPaths(graph, src, target, "");
  }
}
