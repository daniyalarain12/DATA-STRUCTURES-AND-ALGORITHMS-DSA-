public class exponentialSearch_Problem_1 {
    public static void searchNeighbouringElements(int[] arr,int target,int bm,int am) {
        int beforeMid = bm, afterMid = am;
        while ( (arr[beforeMid]==target) || arr[afterMid]==target ) {
            if (arr[beforeMid]==target) {
                System.out.print(beforeMid + " ");
                beforeMid--;
            }
            if (arr[afterMid]==target) {
                System.out.print(afterMid + " ");
                afterMid++;
            }
        }
    }
    public static int binarySearch(int[] arr,int target,int s,int e) {
        int start = s, end = e;
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
        return binarySearch(arr,target,i/2,Math.min(arr.length-1,i));
    }
    public static void main(String[] args) {
        int[] arr = {1,2,7,7,7,7,7,7,7,10};
        int target = 7;
        System.out.println("TARGET FOUND AT INDICES : ");
        System.out.println(exponentialSearch(arr,target));
    }
}
