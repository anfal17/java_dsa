/*---does the src and dest have a path between work */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class hasPath {

    /* algorithm
     1.Checks if src == dest
       returns true
     2.Checks if a not visited neighbour hasPath to dest
       returns true
     else returns false
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

    public static boolean hasPaath(ArrayList<Edge>[] graph, int src , int dest , boolean[] vis){
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if(!vis[e.dest] && hasPaath(graph,e.dest, dest,vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        creategraph(graph);

        hasPaath(graph,0,5,new boolean[V]);
    }

}