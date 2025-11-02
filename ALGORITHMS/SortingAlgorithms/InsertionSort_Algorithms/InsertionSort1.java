public class InsertionSort1 {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev]>current) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = current;
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
        display(arr);
        insertionSort(arr);
        display(arr);
    }
}
