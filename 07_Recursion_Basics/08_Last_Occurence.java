//WAP to find the last occurence of an element in an Array

import java.util.Scanner;

public class javabasics {
  
  
  public static int lastOccurence(int arr[], int i, int key){
    //base case
    if(i == arr.length){
      return  -1;
    }
    
    int isFound = lastOccurence(arr, i+1, key);
    
    
    if(isFound == -1 && arr[i] == key){
      return i;
    }
      
    return isFound;
  
  }
    
    public static void main(String[] args){
      int arr[] = {8,2,3,4,5,4};
      System.out.print(lastOccurence(arr, 0 , 4)); 
    }
  
}
