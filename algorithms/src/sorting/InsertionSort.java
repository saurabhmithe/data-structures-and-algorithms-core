package sorting;

public class InsertionSort {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int marked = a[i];
            int initial = i;

            while (initial > 0 && a[initial - 1] >= marked) {
                a[initial] = a[initial - 1];
                --initial;
            }
            a[initial] = marked;
        }
    }
}
