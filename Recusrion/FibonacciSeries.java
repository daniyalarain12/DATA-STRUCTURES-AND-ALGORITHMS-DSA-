public class FibonacciSeries {
    public static int fibonacci(int n) {
        if (n<1) {
            return 0;
        }
        if (n<3) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.print("FIRST " + n + " TERMS OF FIBONACCI SERIES : ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
