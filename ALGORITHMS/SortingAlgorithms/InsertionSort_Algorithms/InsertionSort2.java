public class LAB_5 {
    public static void InsertionSort2(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev].compareTo(current)>0) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = current;
        }
    }
    public static void display(String [] arr) {
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] arr = {"DANIYAL","BABAR","NAVEEN","MOHSIN","UMAIR"};
        display(arr);
        insertionSort(arr);
        display(arr);
    }
}
