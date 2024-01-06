import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

        // int[] arr = new arr[size];

        // ArrayList<Edge>[] graph = new ArrayList[V]; // graph is null

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

    public static void BFStraversral(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>(); //Queue for storing neighbours
        boolean vis[] = new boolean[graph.length]; //check visited value
        q.add(0); //Source  = 0

        //run loop until queue is empty
        while (!q.isEmpty()) {
            int curr = q.remove();

            //if node not yet visited
            if (!vis[curr]) {
                System.out.print(curr + " "); //print
                vis[curr] = true; //visited true
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); //adding its neightbours
                }
            }
        }
    }

    //Time complexity is O(n) 
    //For adjacency LIST its O(V+E)
    //For adjacency matrix its O(V^2)

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        creategraph(graph);

        BFStraversral(graph);
    }

}