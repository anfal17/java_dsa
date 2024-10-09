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
    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i , vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" " );
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[] , Stack<Integer> s){
        vis[curr] = true;

        for(int i =0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        
    }
}
