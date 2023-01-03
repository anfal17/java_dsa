//WAP to find the first occurence ofa na element in an array

import java.util.Scanner;

public class javabasics {
  
  
  public static int firstOccurence(int arr[], int i, int key){
    //base case
    if(i == arr.length ){
      return  -1;
    }
      
    if(arr[i] == key){
      return i;
    }

    return firstOccurence(arr, i+1, key);
  
  }
    
    public static void main(String[] args){
      int arr[] = {8,2,3,4,5,4};
      int key = 4;
      System.out.print(firstOccurence(arr, 0 , 4)); 
    }
  
}
