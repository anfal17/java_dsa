//Check if array is sorted or not

import.java.util.scanner;

public class Check_Sorted_Array {
  
  public static Boolean isSorted(int arr[], int i){
    if(i == arr.length - 1){
      return true;
    }
    
    if(arr[i] > arr[i + 1]){
      return false;    
    }
    
    return isSorted(arr, i+1);
  
  }
  
  public static void main(String[] args){
    int arr[] = {1,2,3,4,5};
    System.out.print(isSorted(arr, 0)); 
  }

}

