//Print numbers in descending order using recursion

public class 01_printDescending {
  
  public static void printDec(int n) {
//  base case
    if(n == 1){
      System.out.print(n);
      return;
    }
    System.out.print(n +" ");
//  function recall
    printDec(n - 1);
  
  }
    
       
  public staic void main(string args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number");
    int n = sc.nextInt();
    
    printDec(n);
  }
