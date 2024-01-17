package gfg.potd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Algorithm
 * 
1. Initialize an empty result list to store unique permutations.
2. Use a boolean array to keep track of visited elements during permutation generation.
3. Employ a HashSet to store unique permutations and avoid duplicates.
4. Initialize an empty ArrayList to represent the current permutation being generated.
5. Sort the input array to handle duplicate elements effectively.
6. Call the recursive function to generate unique permutations.
7. In the recursive function, if the current permutation is of the same length as the input array, check and add it to the HashSet and result list.
8. Use a loop to iterate through the array elements, checking for visited elements and generating permutations recursively.
9. Backtrack by marking the element as not visited and removing it from the current permutation after recursion.
10. Return the list of unique permutations.
 */

public class uniquePermutations {
    // Function to find all unique permutations of an array
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        // Initialize the result list to store unique permutations
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        // Array to keep track of visited elements during the permutation process
        boolean[] vis = new boolean[n];
        // HashSet to store unique permutations and avoid duplicates
        Set<ArrayList<Integer>> hst = new HashSet();
        // Temporary ArrayList to store the current permutation being generated
        ArrayList<Integer> curr = new ArrayList();
        // Sort the input array to handle duplicate elements
        Collections.sort(arr);
        // Function to check and generate unique permutations
        checPerm(arr, vis, hst, res, curr);
        // Return the list of unique permutations
        return res;
    }

    // Helper function to recursively generate unique permutations
    public static void checPerm(ArrayList<Integer> arr, boolean[] vis, Set<ArrayList<Integer>> hst,
                                ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr) {
        // If the current permutation is of the same length as the input array
        if (curr.size() == arr.size()) {
            // Check if the permutation is not already present in the HashSet
            if (!hst.contains(curr)) {
                // Add the unique permutation to the HashSet and the result list
                hst.add(new ArrayList(curr));
                res.add(new ArrayList(curr));
            }
            return;
        }
        // Iterate through the array elements
        for (int i = 0; i < arr.size(); i++) {
            // Check if the element is already visited
            if (vis[i] == true) {
                // Skip if the element is already used in the current permutation
                continue;
            }
            // Mark the element as visited
            vis[i] = true;
            // Add the current element to the current permutation
            curr.add(arr.get(i));
            // Recursively generate permutations with the updated current permutation
            checPerm(arr, vis, hst, res, curr);
            // Backtrack: Mark the element as not visited and remove it from the current permutation
            vis[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
