/*CREATE AN ARRAY OF SIZE 100 AND GENERATE 100 ELEMENTS FROM random() METHOD AND
 THEN ADD THOSE 100 ELEMENTS IN THAT ARRAY. CREATE ANOTHER ARRAY THAT CONTAINS ELEMENTS
 OF 1ST ARRAY IN REVERSE ORDER. FIND SMALLEST AND LARGEST ELEMENTS FROM 2ND ARRAY*/
import java.util.Random;

public class DSA_Arrays_Problem_1 {
    public static void main(String[] args) {
        Random sc = new Random();
        int size = 100;
        int[] arr1 = new int[size], arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = sc.nextInt(100);
        }
        for (int i = 0; i < size; i++) {
            arr2[i] = arr1[i];
        }
        int start = 0, end = size-1, temp;
        while (start<=end) {
            temp = arr2[start];
            arr2[start] = arr2[end];
            arr2[end] = temp;
            start++;
            end--;
        }
        System.out.print("ORIGINAL ARRAY : ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("REVERSE ARRAY : ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        for (int i  : arr2) {
            if (i<smallest) {
                smallest = i;
            }
            if (i>largest) {
                largest = i;
            }
        }
        System.out.println("SMALLEST : " + smallest);
        System.out.println("LARGEST : " + largest);
  }
}
