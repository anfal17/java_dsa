public class Pairs_Arrays {

    public static void pairs(int arrays[]) {
        for (int i = 0; i < arrays.length; i++) {
            int current = arrays[i];
            int totalpair = 0 ; 
            for (int j = i + 1; j < arrays.length; j++) {
                System.out.print("("+current+", "+arrays[j]+") ");
                totalpair++;
            }System.out.println();
        }
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        pairs(arrays);

    }
}

//Time Commplexity O(n²)
