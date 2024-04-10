package recursion;

public class RecursionTest {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(fact(10));
        long end = System.nanoTime()- start;
        System.out.println(end);
    }
    static int fact(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*fact(n-1);
    }
}
