public class exponentialSearch1 {
    public static int binarySearch(int[] arr,int target,int s,int e) {
        int start = s, end = e;
        while (start<=end) {
            int mid = (start+end)/2;
            if (arr[mid]==target) {
                return mid;
            } else if (arr[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static int exponentialSearch(int[] arr,int target) {
        if (arr[0]==target) {
            return 0;
        }
        int i = 1;
        while ( (i<arr.length) && arr[i]<target) {
            i*=2;
        }
        return binarySearch(arr,target,i/2,Math.min(arr.length-1,i));
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 7;
        System.out.println("TARGET FOUND AT INDEX : " + exponentialSearch(arr,target));
    }
}
