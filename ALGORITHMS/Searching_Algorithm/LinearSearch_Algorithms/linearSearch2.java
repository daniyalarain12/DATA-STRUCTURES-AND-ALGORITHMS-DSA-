public class linearSearch2 {
    public static int linearSearch(String[] arr,String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toLowerCase().contains(target)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] arr = {"DANIYAL","UMAIR","ali RAZA","MOHAMMAD ALI","SIR NAVEEN KUMAR"};
        String target = "ali";
        System.out.println("TARGET IS PRESENT AT INDEX : " + linearSearch(arr,target));
    }
}
