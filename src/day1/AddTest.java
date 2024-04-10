package day1;

class AddTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        long start = System.nanoTime();
        System.out.println(calc.addNew(1000000));
        double duration = (double) (System.nanoTime() - start) /1000000;
        System.out.println(duration + "ms");
    }
}

class Calculator{
    long add(long N){
        long sum = 0;
        for(int i = 0; i<=N; i++){
            sum = sum+i;
        }
        return sum;
    }
    long addNew(long N){
        return N*(N+1)/2;
    }
}