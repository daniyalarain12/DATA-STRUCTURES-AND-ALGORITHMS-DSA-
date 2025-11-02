/*CREATE AN ARRAY OF SIZE 100 AND GENERATE 100 ELEMENTS FROM random() METHOD AND
 THEN ADD THOSE 100 ELEMENTS IN THAT ARRAY. CREATE ANOTHER ARRAY THAT CONTAINS ELEMENTS
 OF 1ST ARRAY IN REVERSE ORDER. FIND SMALLEST AND LARGEST ELEMENTS FROM 2ND ARRAY*/
import java.util.Random;
public class DSA_Arrays_Problem_1 {
    public static void reverse(int[] arr) {
        int start = 0, end = arr.length-1;
        int temp;
        while (start<=end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void smallestLargest(int[] arr) {
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<smallest) {
                smallest = arr[i];
            }
            if (arr[i]>largest) {
                largest = arr[i];
            }
        }
        System.out.println("SMALLEST ELEMENT : " + smallest);
        System.out.println("LARGEST ELEMENT : " + largest);
    }
    public static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random sc = new Random();
        int size = 40;
        int[] arr = new int[size], arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt(20);
        }
        System.arraycopy(arr,0,arr2,0,size);
        System.out.print("ORIGINAL ARRAY : ");
        display(arr2);
        reverse(arr2);
        System.out.print("REVERSE ARRAY : ");
        display(arr2);
        smallestLargest(arr2);
    }
}
