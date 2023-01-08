/*It is a sweltering summer day, and a boy wants to buy some ice cream bars.
At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 
Return the maximum number of ice cream bars the boy can buy with coins coins.*/

// Approach 1

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int sum = 0;
        int count = 0;

        for(int i =0; i < costs.length ;i++ ){
            sum += costs[i];
            count++;
            
            if(sum == coins){
                return count; // if sum reaches the value of total coins then return the count
            }
            
            if(sum > coins){
                return count -1 ; //count-1 ,as even if the coins are less next item will be added in sum
            }
        }
        return count;
    } 
}

//Approach 2
//Here the cost is directly decreades form the coins itself

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Store ice cream costs in increasing order.
        Arrays.sort(costs);
        int n = costs.length;
        int answer = 0;
        // Pick ice creams till we can.
        while (answer < n && costs[answer] <= coins) {
            // We can buy this icecream, reduce the cost from the coins. 
            coins -= costs[answer];
            answer += 1;
        }
        return answer;
    }
}
  
