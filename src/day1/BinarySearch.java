package day1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        int target = 777777;
        BS bs = new BS();
        int value = bs.binarySearch(array, target);
        System.out.println("Index is: " + value);
    }
}
 class BS {
    public int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = array[middle];
            System.out.println("middle: " + value);
            if (value < target) {
                low = middle + 1;
            } else if (value > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
