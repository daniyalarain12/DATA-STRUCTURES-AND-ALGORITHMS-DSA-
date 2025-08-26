public class insertionSort2 {
    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String  key = arr[i];
            int j = i-1;
            while ( (j>=0) && (arr[j].compareTo(key)>0) ) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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
