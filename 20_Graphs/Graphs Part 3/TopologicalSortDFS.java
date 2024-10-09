import java.util.*;

public class TopologicalSortDFS {

  /*
     * Topological Sort is used only for DAG's 
     * It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order.
     * 
     * Topological Sort Using DFS
     * first we use an outer loop to vsit all nodes and we also use a stack to keep track of all nodes
     * 
     * Then in topSortUtil
     * first we update the visted node
     * then we visit the on visited neighbours of the vertex
     * then we push them to the stack
     * 
     * then in the topSortUtil we pop() and print all stack elements
     * 
     * 
     Algorithm for Topological Sort using DFS:

      1. Initialize an array 'visited' to keep track of visited vertices and a stack to store the topological order.
      2. For each vertex in the graph:
        a. If the vertex is not visited, call the 'topSortUtil' function.
      3. 'topSortUtil' function:
        a. Mark the current vertex as visited.
        b. Explore all unvisited neighbors of the current vertex recursively.
        c. After visiting all neighbors, push the current vertex onto the stack.
      4. After the loop in step 2, the stack contains the topological order.
      5. Print the vertices from the stack to get the topological order of the graph.
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

  //O(V+E)
  public static void topSort(ArrayList<Edge>[] graph) {
    // Array to keep track of visited vertices
    boolean vis[] = new boolean[graph.length];

    // Stack to store vertices in topological order
    Stack<Integer> s = new Stack<>();

    // Loop through all vertices in the graph
    for (int i = 0; i < graph.length; i++) {
      // If the vertex is not visited, perform topological sort starting from this vertex
      if (!vis[i]) {
        topSortUtil(graph, i, vis, s);
      }
    }

    // Print vertices in topological order by popping from the stack
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topSortUtil(
    ArrayList<Edge>[] graph,
    int curr,
    boolean vis[],
    Stack<Integer> s
  ) {
    // Mark the current vertex as visited
    vis[curr] = true;

    // Visit all unvisited neighbors of the current vertex
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topSortUtil(graph, e.dest, vis, s);
      }
    }

    // Push the current vertex to the stack after all its neighbors are visited
    s.push(curr);
  }

  public static void main(String[] args) {
    
  }
}
