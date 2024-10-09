import java.util.*;

public class BellmanFord {

  /*
     * Calculates the shortest distance from a single source vertex to all other vertices in a weighted graph, even when negative weights are present.
     * Dijkstra vs. Bellman-Ford:
        ->Dijkstra's algorithm is suitable for graphs with non-negative weights. It fails to provide correct results when negative weights are present.
        ->Bellman-Ford handles graphs with negative weights and can detect negative weight cycles 
     * Bellman-Ford algorithm works correctly as long as there are no negative weight cycles in the graph.
     * TC is O(VE)
     
     * Algorithm for Bellman-Ford Algorithm:
      1.Initialize an array 'dist' for storing shortest distances.
      2.Set all distances to infinite except for the source (dist[src] = 0).
      3.Perform the following loop V - 1 times:
        a. Iterate through all edges in the graph.
        b. For each edge (u, v) with weight 'wt':
            i. If the distance to vertex 'u' is not infinite and the sum of the distance to 'u' and the weight 'wt' is less than the distance to 'v':
            - Update the distance to 'v' with the new shorter distance.
      4.Print the shortest distances from the source to all vertice
     
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

  public static void bellmanFords(ArrayList<Edge>[] graph, int src) {
    int[] dist = new int[graph.length];

    for (int i = 0; i < dist.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    int V = graph.length;

    // Loop V - 1 times to relax edges and find the shortest paths
    for (int i = 0; i < V - 1; i++) {
      // Iterate through all vertices
      for (int j = 0; j < graph.length; j++) {
        // Iterate through all edges of the current vertex
        for (int k = 0; k < graph[j].size(); k++) {
          // Consider an edge (u, v) with weight 'wt'
          Edge e = graph[j].get(k);
          int u = e.src;
          int v = e.dest;
          int wt = e.weight;

          // If a shorter path is found from the source to 'v' through 'u', update the distance to 'v'
          if (dist[u] != Integer.MAX_VALUE && (dist[u] + wt < dist[v])) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }

    for (int i = 0; i < dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {}
}
