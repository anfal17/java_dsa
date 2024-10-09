import java.lang.reflect.Array;
import java.util.*;

public class Bipartite {
        /*      0
               / \
              1   2
              |   |
              3---4
        */

    /*Bipartite Graph -A graph whose vertices can be converted into 2 independent sets
     * Set u and set v such that no elements u,v dont belong to same set
     * 
     * Solve using Graph coloring
     * Assign color using BFS
     * color - 0 , 1 , -1  where 0 yellow 1 blue -1 is  no color
     * 
     * three cases - 3
     * -case 1: if neighbour has same color -> return false
     * -case 2: if neighbour has different color -> continue
     * -case 3: if neighbour has no color -> assign opposite color + push in Q 
     */

     //Tc O(V+E)

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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[0].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipatrite(ArrayList<Edge>[] graph){
        
        int col[] = new int[graph.length];//Array to store color of each vertex

        for (int i = 0; i < col.length; i++) {
            col[i] = -1;//assign nocolor by default
        }

        Queue<Integer> q = new LinkedList<>();//Q for BFS
        
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { //BFS
                q.add(i);
                col[i] = 0; //0 -> yellow
                while (!q.isEmpty()) { //BFS logic
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); //e.dest

                        //3 cases of finding bipatrite
                        //case 1 -> neighbour has no color => assign color and push in queue
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ?1:0; //if color of curr is 0  then give neighbour color as 1
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        //case 2 -> color of neighbour same as curr => not Bipartite
                        else if(col[e.dest] == col[curr]){
                            return false; //Not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }
  
    
    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        creategraph(graph);
        
       System.out.println(detectCycle(graph)); 

    }

}
