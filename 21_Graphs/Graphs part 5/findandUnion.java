import java.util.*;

public class findandUnion {

    /*
     *Disjoint Set -> to store and track non   overlapping sets
      ->used in krushkal
      ->in cycle detection

     * find()
       ->find to which set x belongs to
       ->finds the parent of node 
      
     * union()
       ->joins two sets
       ->implemented based on rank of the parent
      
     *Implementation
       -using parent and rank
       -initially parent is same element itself
       -later on union the higher ranked node is parent

     */

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void initialise(){
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }
        
    public static int find(int x){
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
        //optimised return par[x] = find[x];
        //path compression - tree size decreases 
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        //union leder is made based on rank of nodes
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        }else{
            par[parB] = parA;
            rank[parA]++;
        }
    }

        public static void main(String[] args) {
            initialise();
            union(1, 3);
            System.out.println(find(3));
            union(2, 4);
            union(3, 6);
            System.out.println(find(3));
            union(1, 4);
        }

}
