import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }

        maxSubArraySum(arr);
        
    }

    static void maxSubArraySum(int[] arr){

        int n = arr.length ;

        int currentsum = 0 ;
        int maxSum = Integer.MIN_VALUE;

        int start = 0 ;
        int end  = 0 ;

        int initialstart = 0 ;

        for(int i = 0 ; i < n ; i++){

            currentsum += arr[i] ;


            if(currentsum > maxSum){
                maxSum = currentsum ;
                start = initialstart ;
                end = i ;
            }

            if(currentsum < 0){
                currentsum = 0 ;
                initialstart = i + 1 ;
            }            
        }
        System.out.println("Elements contributing for max sum are: ");
        for(int j = start ; j <= end ; j++ ){
            System.out.print(arr[j]+" ");
        }
        System.out.println();

        System.out.println("Maximum sum is: "+maxSum);
        // System.out.println(maxSum);

    }
}
