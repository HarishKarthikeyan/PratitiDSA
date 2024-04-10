package day1;

public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 10, 12, 11, 9, 7, 6, 8};
        SS(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void SS(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}
