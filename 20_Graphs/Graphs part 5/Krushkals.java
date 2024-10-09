import java.util.*;

public class Krushkals {

  /*
     * 
    1. Initialize arrays 'par' and 'rank' for disjoint set operations.
        - 'par' represents the parent of each element in the set initially pointing to itself.
        - 'rank' represents the rank (depth) of each element in the set.

    2. Initialize a method 'initialise' to set each element's parent as itself.

    3. Implement the 'find' method to find the representative element of the set using recursive path compression.

    4. Implement the 'union' method to merge two sets based on their ranks.

    5. Create a class 'Edge' representing the edges with source, destination, and weight. Implement 'compareTo' to compare edges based on weight.

    6. Implement a method 'creategraph' to initialize the graph with edges.

    7. Implement Kruskal's Algorithm:
        a. Initialize disjoint sets using 'initialise'.
         b. Sort the edges in non-decreasing order based on weight.
        c. Initialize 'mstCost' to store the total weight of the MST and 'count' to track the number of edges added.
        d. Iterate through sorted edges:
            i. Get the current edge.
            ii. Find the representatives of the sets containing the source and destination vertices.
            iii. If the representatives are different, union the sets, update 'mstCost', and increment 'count'.
        e. Print the final cost of the MST.

        Algorithm:
        1. Initialize disjoint sets using 'initialise'.
        2. Sort the edges in non-decreasing order based on weight.
        3. Initialize 'mstCost' and 'count'.
        4. Iterate through sorted edges until edges no. < V-1:
            a. Get the current edge.
            b. Find parent of sets containing source and destination vertices.
            c. If parents are different, union the sets, update 'mstCost', and increment 'count'.
        5. Print the final cost of the MST.
     */
  static int n = 7;
  static int par[] = new int[n];
  static int rank[] = new int[n];

  public static void initialise() {
    for (int i = 0; i < n; i++) {
      par[i] = i;
    }
  }

  public static int find(int x) {
    if (x == par[x]) {
      return x;
    }
    return find(par[x]);
    //optimised return par[x] = find[par[x]];
    //path compression - tree size decreases
  }

  public static void union(int a, int b) {
    int parA = find(a);
    int parB = find(b);

    //union leder is made based on rank of nodes
    if (rank[parA] == rank[parB]) {
      par[parB] = parA;
      rank[parA]++;
    } else if (rank[parA] < rank[parB]) {
      par[parA] = parB;
      rank[parB]++;
    } else {
      par[parB] = parA;
      rank[parA]++;
    }
  }

  static class Edge implements Comparable<Edge> {

    int src;
    int dest;
    int weight;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.weight = w;
    }

    @Override
    public int compareTo(Edge e2) {
      return this.weight - e2.weight;
    }
  }

  static void creategraph(ArrayList<Edge> edges) {
    int V = 5;

    edges.add(new Edge(0, 1, 10));

    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));

    edges.add(new Edge(1, 1, 40));
    edges.add(new Edge(2, 3, 50));
  }

  public static void kruskalsAlgo(ArrayList<Edge> edges, int V) {
    initialise();
    Collections.sort(edges);
    int mstCost = 0;
    int count = 0;

    for (int i = 0; count < V - 1; i++) {
      Edge e = edges.get(i);

      int parA = find(e.src);
      int parB = find(e.dest);
      if (parA != parB) {
        union(e.src, e.dest);
        mstCost += e.weight;
        count++;
      }
    }

    System.out.println("Cost of MST = " + mstCost);
  }

  public static void main(String[] args) {
    int V = 4;
    ArrayList<Edge> edges = new ArrayList<>();
    creategraph(edges);
    kruskalsAlgo(edges, V);
  }
}
