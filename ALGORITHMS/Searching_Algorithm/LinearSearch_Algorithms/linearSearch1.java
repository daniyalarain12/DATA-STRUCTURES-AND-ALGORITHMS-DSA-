public class linearSearch1 {
    public static int linearSearch(int[] arr,int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,3,6,1,9,7,8,5,10};
        int target = 7;
        System.out.println("TARGET " + target + " IS FOUND AT INDEX : " + linearSearch(arr,target));
    }
}
