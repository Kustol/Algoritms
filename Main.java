package HW_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{
                44, 55, 22, 88, 77, 33, 99, 11, 66, 111
        };
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int array[]) {
        int n = array.length;


        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);


        for (int i = n - 1; i >= 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            heapify(array, i, 0);
        }
    }

    static void heapify(int array[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;


        if (l < n && array[l] > array[largest])
            largest = l;


        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;


            heapify(array, n, largest);
        }
    }
}
