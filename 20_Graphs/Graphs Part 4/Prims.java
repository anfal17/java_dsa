import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
   /*
     Prims algorithm is used to calculate the toatl cost of mst or to create a minimum Spanning tree
     
     What is a MST?
     -MST is a subgraph, wieghted, acyclic, having minimum number of edges connected to all vertices.
    
     Algorithm
     1. Initialize a boolean array 'vis' to track visited vertices.
     2. Create a priority queue 'pq' of pairs to prioritize vertices with lower costs.
     3. Add the source vertex to the priority queue with a cost of 0.
     4. Initialize variables:
        - 'finalCost' to keep track of the total cost of the MST.
        - 'mstEdges' as an ArrayList to store the edges included in the MST.
     5. While the priority queue is not empty:
        a. Remove the vertex with the minimum cost from the priority queue.
        b. If the vertex has not been visited:
            i. Mark the vertex as visited.
           ii. Update 'finalCost' by adding the current vertex's cost.
          iii. Iterate through all edges of the current vertex:
                - If the destination vertex is not visited, add the edge to 'mstEdges' and add the destination vertex and weight to the priority queue.
     6. Print the edges included in the MST and the final cost of the MST.

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

 static class Pair implements Comparable<Pair>{
    int v;
    int cost;

    public Pair(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair p2){
        return this.cost - p2.cost;
    }
 }
 
  public static void primsMSTCost(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, 0));

    int finalCost = 0; // To find cost
    ArrayList<Edge> mstEdges = new ArrayList<>(); // to find edges included in MST

    while (!pq.isEmpty()) {
        Pair curr = pq.remove();
        if (!vis[curr.v]) {
            vis[curr.v] = true;
            finalCost += curr.cost;

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);               
                pq.add(new Pair(e.dest, e.weight));
                mstEdges.add(e);
            }

        }
    }

    System.out.print("Edges in MST : ");
    for (Edge e : mstEdges) {
        System.out.print("("+e.src+","+e.dest+")" +"  ");
    }
    System.out.println("Final cost of MST = "+ finalCost);
  }

  public static void main(String[] args) {
    int v =5;
    ArrayList<Edge>[] graph = new ArrayList[v];
    creategraph(graph);

    primsMSTCost(graph);
  }
}
