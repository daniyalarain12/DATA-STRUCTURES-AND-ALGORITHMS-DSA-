public class linearSearch2 {
    public static int[] linearSearch(String[] arr,String target) {
        int[] dummy = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toLowerCase().contains(target)) {
                dummy[count] = i;
                count++;
            }
        }
        int[] record = new int[count];
        for (int i = 0; i < count; i++) {
            record[i] = dummy[i];
        }
        return record;
    }
    public static void main(String[] args) {
        String[] arr = {"DANIYAL","UMAIR","ali RAZA","MOHAMMAD ALI","SIR NAVEEN KUMAR"};
        String target = "ali";
        int[] arr2 = linearSearch(arr,target);
        System.out.print("TARGET IS PRESENT AT INDICES : ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
