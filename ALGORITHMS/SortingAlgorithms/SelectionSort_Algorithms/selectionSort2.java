public class selectionSort2 {
    public static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int smallestIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if ( ( arr[j].compareTo(arr[smallestIndex]) ) <0) {
                    smallestIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
    public static void display(String[] arr) {
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] arr = {"DANIYAL","BABAR","NAVEEN","MOHSIN","UMAIR"};
        display(arr);
        selectionSort(arr);
        display(arr);
    }
}
