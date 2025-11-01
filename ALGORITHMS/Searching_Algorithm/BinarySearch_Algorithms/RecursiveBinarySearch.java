// Binary Search Using Recursion
public class RecursiveBinarySearch {
    public static int binarySearch(int[] arr,int target,int start,int end) {
        if (start<=end) {
            //int mid = (start+end)/2;
            int mid = start + (end-start)/2;
            if (arr[mid]==target) {
                return mid;
            } else if (arr[mid]<target) {
                return binarySearch(arr,target,mid+1,end);
            } else {
                return binarySearch(arr,target,start,mid-1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        System.out.println("TARGET " + target + " FOUND AT INDEX : " + binarySearch(arr,target,0,arr.length-1));
    }
}
