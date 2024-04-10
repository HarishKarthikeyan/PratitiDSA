package day1;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int arr[] = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        long start = System.nanoTime();
        bubbleSort(arr);
//        Arrays.sort(arr);
        double duration = (double) (System.nanoTime() - start) /1000000;
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println(duration + "ms");
    }

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
