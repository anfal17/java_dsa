import java.lang.reflect.Array;
import java.util.*;

public class UndirectedcycleDetection {
        /*
           0------3
         /   \     \
        /     \     \
       1-------2     4

        */

    /*
     * Detect cycle in undirected graph
     * cycle is found if a node is visited and is not a parent
     * We modify the DFS algo tofind cycle in a graph
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

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i , -1)) {
                  return true;  
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr ,int par){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //Case 3 - not visited  
            if (!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            //case 1 - iscycle if node visited and is not the parent
            else if(vis[e.dest] && e.dest != par ){
                return true;
            }
            //case 2 -> continue nothing to do
        }
        return false;
    }
    
    
    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        creategraph(graph);
        
       System.out.println(detectCycle(graph)); 

    }

}
