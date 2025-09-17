public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};

        if (arr == null || arr.length == 0) 
            System.out.println("no element in the array");

        int start = 0;
        int end = arr.length -1 ;

        while(start < end){
            int mid = start + (end - start)/2 ;

            if(arr[mid] > arr[mid+1]){
                System.out.println("Index of peak elemen is:"+mid+" and value is: "+arr[mid]);
            }

            if(arr[mid] < arr[mid+1]){
                start = mid + 1 ;
            }
            else{
                end = mid ;
            }
        }

    }
}
