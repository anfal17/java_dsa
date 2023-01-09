//Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

//Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

//My solution 1
class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i =0; i < arr.length - 1 ; i++){ //length is arr.length  -1 else array will ronoutofbounds
            
            //everytime a zero comes we first shift 
            if(arr[i] == 0){
                
                //shifting by 1 place to right
                for (int j = arr.length - 2; j >= i ; j--)
                {
                   arr[j + 1] = arr[j];
                }
                
                arr[i+1] = 0;   //arr[i + 1] bcouz already i is zero we need to duplicate
                
                i++; //we need to iterarte or else the next i will be duplicated zero and this will continue and the result will be array full of zeroes



            }
        }
    }
}
