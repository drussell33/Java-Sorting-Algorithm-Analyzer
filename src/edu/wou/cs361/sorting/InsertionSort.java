package edu.wou.cs361.sorting;

public class InsertionSort implements ISort {
    @Override
    public long sort(final Comparable[] array) {
        if (array == null) throw new IllegalArgumentException();

        long count = 0;
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                ++count;
                if (less(array[j], array[j-1]))
                    exch(array, j, j-1);
                else break;
            }
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
