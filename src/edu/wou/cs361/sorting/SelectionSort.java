package edu.wou.cs361.sorting;

public class SelectionSort implements ISort {
    /**
     * Sort the array into ascending order using the Selection Sort algorithm
     *
     * @param array An Array of Comparable items
     * @return Returns the number of compares done in the sort
     * @throws IllegalArgumentException if the argument is null
     */
    @Override
    public long sort(final Comparable[] array) {
        if (array == null) throw new IllegalArgumentException();

        long count = 0;
        int N = array.length;
        for (int i = 0; i < N -1 ; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++){
                ++count;
                if(less(array[j], array[min])){
                    min = j;
                }
            }
            exch(array, i, min);

        }
        return count;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;  }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap; }
}
