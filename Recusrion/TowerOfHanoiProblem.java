public class TowerOfHanoiProblem {
    public static void towerOfHanoi(int n,char source,char helper,char destination) {
        if (n==1) {
            System.out.println("SOURCE " + source + " --> DESTINATION " + destination);
            return;
        }
        towerOfHanoi(n-1,source,destination,helper);
        System.out.println("SOURCE " + source + " --> DESTINATION " + destination);
        towerOfHanoi(n-1,helper,source,destination);
    }
    public static void main(String[] args) {
        char source = 'S', helper = 'H', destination = 'D';
        int n = 3;
        towerOfHanoi(n,source,helper,destination);
    }
}
