package dp;

public class FibonacciTest {
        static void Fibonacci(int N)
        {
            int num1 = 0, num2 = 1;

            for (int i = 0; i < N; i++) {
//                System.out.print(num1 + " ");
                int num3 = num2 + num1;
                num1 = num2;
                num2 = num3;
            }
        }
        public static void main(String[] args)
        {
            long start = System.nanoTime();
//            System.out.println(start);
//            Fibonacci(10);
//            long end = System.nanoTime();
//            System.out.println(end-start);
//            end = System.nanoTime();
            System.out.println("\n"+fib(10));
//            fib(10);
//            System.out.println(end-start);
//            fibArr(10);
        }
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
    static int fibArr(int n){
            if(n<=1){
                return n;
            }
            int[] F = new int[10];
            F[0] = 0;
            F[1] = 1;
            for(int i = 0; i<=n; i++){
                F[i] = F[i-1]+F[i-2];
            }
        return F[n];
    }

}
