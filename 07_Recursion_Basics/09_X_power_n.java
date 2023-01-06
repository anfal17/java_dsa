import java.util.Scanner;

public class javabasics {
  
  
  public static int power(int x, int n){
    //base case
    if(n == 0){
      return  1;
    }
    
    return x * power(2,10);
  
  }
    
    public static void main(String[] args){
      int arr[] = {8,2,3,4,5,4};
      System.out.print(lastOccurence(arr, 0 , 4)); 
    }
  
}
