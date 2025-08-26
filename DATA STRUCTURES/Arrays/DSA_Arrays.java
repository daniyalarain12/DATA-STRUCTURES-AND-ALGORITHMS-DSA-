/*RE-SIZING AN ARRAY*/
public class DSA_Arrays {
    public static int[] resize(int[] arr1,int n) {
        if (n<arr1.length) {
        throw new IllegalStateException();
        }
        int[] arr2 = new int[n];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        return arr2;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("SIZE BEFORE RE-SIZING : " + arr.length);
        arr = resize(arr,10);
        System.out.println("SIZE AFTER RE-SIZING : " + arr.length);
    }
}
