package sorting;

public class SelectionSort {

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minimum = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minimum]) {
                    minimum = j;
                }
            }
            int temp = a[i];
            a[i] = a[minimum];
            a[minimum] = temp;
        }
    }

}
