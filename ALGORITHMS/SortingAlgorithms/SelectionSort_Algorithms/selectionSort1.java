public class selectionSort1 {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int smallestIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
    public static void display(int [] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {23,12,56,78,45,36,60,21};
        display(arr);
        selectionSort(arr);
        display(arr);
    }
}
