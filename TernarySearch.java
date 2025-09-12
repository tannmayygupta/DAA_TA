public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        int ans = ternarySearch(arr, 0, 9, 5);

        System.out.println(ans);

    }

    public static int ternarySearch(int[] arr, int st, int end, int target) {

        while (st <= end) {
            int mid1 = st + (end - st) / 3;

            // int mid2 = mid1 + mid1; what happen is that

            int mid2 = end - (end - st) / 3 ;  // jaise start se mid nikale waise hi last se mid nikale so that 

            if (arr[mid1] == target) {
                return mid1;
            } else if (arr[mid2] == target) {
                return mid2;
            }

            if(arr[mid2] < target){
                st = mid2 + 1 ; // as mid2 is being checked if it is not target then only it will come here
            }
            else if(arr[mid1] > target){
                end = mid1 - 1 ;
            }else{
                st = mid1 + 1 ;
                end = mid2 - 1 ;
            }
        }

        return -1;
    }
}
