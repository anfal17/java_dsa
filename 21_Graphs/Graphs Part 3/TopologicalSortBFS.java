import java.util.*;

public class TopologicalSortBFS {
    /*
     * Topological Sort is used only for DAG's 
     * It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order.
     * 
     * 
     * Topological Sort Using BFS
     * main approach is using indegree and outdegree
     * Fact- A DAG has atleast one vertex with indegree 0 and atleast one vertex with outdegree 0
     * 
     * algorithm
     * ~calculate indegree of all vertices and store ina an ~Array
     * ~then if indegree is == 0
     *  ~Add in Queue  
     * Print the element in Queue and decrease the indegree of the vertexs neighbours
     * 
     * Calculating the indegree
     * ~loop ove graph array
     * ~for each vertex find if there are edges to other destinations
     * then indeg[e.dest]++
     * 
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

    public static void calculateIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int V = i;
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    
    //O(V+E)
    public static void topSort(ArrayList<Edge>[] graph){
        // boolean vis[] = new boolean[graph.length]; ~~Not required because as indegree becomes 0 we dont visit the vertex
        int[] indeg = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" " );

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

   
    public static void main(String[] args) {
        
    }
}
