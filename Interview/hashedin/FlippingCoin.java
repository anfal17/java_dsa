//https://www.naukri.com/code360/problems/flipping-coins_764604?leftPanelTabValue=PROBLEM

import java.util.* ;
import java.io.*; 

public class FlippingCoin {

    public static int flippingCoins(int[] arr) {
        //Write your code here
        int i = 0;
        int n = arr.length;

        int initialH = 0;

        while(i < n){
            initialH += arr[i];
            i++;
        }

        int newHeads = maximumHeads(arr);

        return initialH + newHeads;
    }

    public static int maximumHeads(int[] arr){
        int n = arr.length;
        int maxSoFar = 0 , maxEndingHere = 0;

        for(int i = 0; i < n;i++){
            if(arr[i] == 1){
                maxEndingHere += -1;
            }
            else{
                maxEndingHere += 1;
            }

            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }

            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }

        }
            return maxSoFar;

    }

}