import java.util.*;

class sync {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 8, 4, 15, 6};
        
        int n = arr.length;
        // int peakElement = -1;
        // int flag = 0;
        
        //question 2 need to optimise - FINDING MIN AND MAX
        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;
        
        for(int i = 0; i< n;i++){
            if(arr[i] > maxEle) maxEle = arr[i];
            if(arr[i] < minEle) minEle = arr[i];
        }
        
        System.out.println(minEle);
        System.out.println(maxEle);
        


      //finding the peak element 
        // //for last element
        // if(arr[n-1] >= arr[n-2]){
        //     peakElement = arr[n-1];
        //     System.out.println(peakElement);
        //     flag = 1;
        // }
        
        
        // if(flag != 1){
        // //for all other elements
        // for(int i = n-2; i > 0;i--){
        //     if(arr[i] >= arr[i-1] && arr[i] >= arr[i+1]){
        //         peakElement = arr[i];
        //         System.out.println(peakElement);
        //         flag = 1;
        //         break;
        //     }
        // }
        // }
        
        // if(flag != 1){
        // //handle first element
        // if(arr[0] >= arr[1]){
        //     peakElement = arr[0];
        //     System.out.println(peakElement);
        // }
        // }
        
        
    }
}


//kadanes algo , weighted strings

//java core - static, final , finalise , volatile, serializeinterface
//layered architecture why nodejs, mongodb,?? nodes clusters, kubernetes


//maximum subarrays sum
// Online Java Compiler
// Use this editor to write, compile and run your Java code online


public static void main(String[] args) {
    // int[] arr = {-2 , -1 ,2 -10, -30,50};
    int[] arr = {-2 , -50 ,-3, -4,0 };
        
    int curSum = 0;
    int maxSum = Integer.MIN_VALUE;

        
    for(int i = 0; i < arr.length ;i++){
        curSum += arr[i];
        if(curSum > maxSum) {maxSum = curSum;} 
        if(curSum < 0) {curSum = 0;}
            
    }    
    System.out.println(maxSum);
}
