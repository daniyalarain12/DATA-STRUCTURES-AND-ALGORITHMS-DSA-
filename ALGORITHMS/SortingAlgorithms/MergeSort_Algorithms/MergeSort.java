public class MergeSort {
    public static void merge(int[] arr,int start,int mid,int end) {
        int[] temp = new int[end-start+1];
        int leftIndex = start, rightIndex = mid+1;
        int count = 0;
        while (leftIndex<=mid && rightIndex<=end) {
            if (arr[leftIndex]<=arr[rightIndex]) {
                temp[count++] = arr[leftIndex++];
            } else {
                temp[count++] = arr[rightIndex++];
            }
        }
        while (leftIndex<=mid) {
            temp[count++] = arr[leftIndex++];
        }
        while (rightIndex<=end) {
            temp[count++] = arr[rightIndex++];
        }
        for (int i = 0, j = start; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
        //System.arraycopy(temp,0,arr,start,temp.length);
    }
    public static void divide(int[] arr,int start,int end) {
        if (start<end) {
            int mid = (start+end)/2;
            divide(arr,start,mid);
            divide(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {23,12,56,78,45,36,60,21};
        int start = 0, end = arr.length-1;
        display(arr);
        divide(arr,start,end);
        display(arr);
    }
}
