package sorting;

public class MergeSort {

    private static void mergeSort(int[] array) {
        int helper[] = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int middle, int high) {

        // Copy the original array to the helper array
        for (int i = 0; i <= high; i++) {
            helper[i] = array[i];
        }

        int current = low;
        int helperLeft = low;
        int helperRight = middle + 1;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft++];
            } else {
                array[current] = helper[helperRight++];
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current++] = helper[helperLeft++];
        }
    }
}
