public class linearSearch4 {
    public static int thirdTargetIndex(String[] arr,String target,int times) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target) {
                count++;
            }
            if (count==times) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] arr = {"DANIYAL","UMAIR","UMAIR","MOHAMMAD ALI","UMAIR","SIR NAVEEN KUMAR","UMAIR"};
        String target = "UMAIR";
        int times = 3;
        System.out.println("THIRD TIME TARGET EXIST AT INDEX : " + thirdTargetIndex(arr,target,times));
    }
}
