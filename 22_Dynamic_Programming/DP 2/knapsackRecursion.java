
public class knapsackRecursion {
    
    public static int knapsack(int val[], int wt[], int kpCapacity, int n) {
        //Base case
        if(kpCapacity == 0 || n ==0){
            return 0;
        }

        if (wt[n-1] <= kpCapacity) {
            //Include item so kpcapacity decreses
            int ans1 = val[n-1]+knapsack(val, wt, kpCapacity - wt[n-1], n-1);

            //Exclude item move to next
            int ans2 = knapsack(val, wt, kpCapacity, ans1);

            return Math.max(ans1, ans2);
        }else{ //not valid move to next
            return knapsack(val, wt, kpCapacity, n-1);
        }
    }

    public static void main(String[] args) {
        int wt[] = {15, 14 ,10, 45, 30};
        int val[] = {2,5,1,3,4};
        int kpCapacity = 5;
        int n = 5;

        knapsack(val, wt, kpCapacity, n);

    }
}
