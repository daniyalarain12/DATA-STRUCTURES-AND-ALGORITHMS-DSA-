/*Write a Java program to implement Exponential Search that finds a target element in a sorted array.
If the target appears multiple times, display all indices where it occurs using a helper method.*/
public class exponentialSearch_Problem_1 {
    public static void searchNeighbouringElements(int[] arr,int target,int beforeMid,int afterMid) {
        while ((beforeMid>=0 && arr[beforeMid]==target) || (afterMid<arr.length) && arr[afterMid]==target) {
            if (beforeMid>=0 && arr[beforeMid]==target) {
                System.out.print(beforeMid + " ");
                beforeMid--;
            }
            if (afterMid<arr.length && arr[afterMid]==target) {
                System.out.print(afterMid + " ");
                afterMid++;
            }
        }
    }
    public static int binarySearch(int[] arr,int target,int start,int end) {
        while (start<=end) {
            int mid = (start+end)/2;
            if (arr[mid]==target) {
                searchNeighbouringElements(arr,target,mid-1,mid+1);
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
        return binarySearch(arr,target,i/2,Math.min(i,arr.length-1));
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,7,7,7,7,10};
        int target = 7;
        System.out.println("TARGET FOUND AT INDICES : ");
        System.out.println(exponentialSearch(arr,target));
    }
}
