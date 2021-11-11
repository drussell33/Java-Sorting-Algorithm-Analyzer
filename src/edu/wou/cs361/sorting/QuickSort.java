package edu.wou.cs361.sorting;

public class QuickSort implements ISort {
    /**
     * Sort the array into ascending order using QuickSort
     *
     * @param array An Array of Comparable items
     * @return Returns the number of compares done in the sort
     * @throws IllegalArgumentException if the argument is null
     */
    @Override
    public long sort(final Comparable[] array) {
        if (array == null) throw new IllegalArgumentException();

        long count = 0;
        count += quicksort(array, 0, array.length - 1);

        return count;
    }

    private static final int CUTOFF = 10;

    public static final void swapReferences(Object [] a, int index1, int index2) {
        var tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static long quicksort(Comparable [] a, int low, int high) {
       long count = 0;
        if ( low + CUTOFF > high ){
            count += insertionSort( a, low, high );
        }

        else{
            int middle = (low + high) / 2;
            ++count;
            if (a[middle].compareTo(a[low] ) < 0){
                swapReferences(a, low, middle);}
            ++count;
            if (a[high].compareTo(a[low]) < 0 ){
                swapReferences(a, low, high);}
            ++count;
            if (a[high].compareTo(a[middle]) < 0){
                swapReferences(a, middle, high);}

            swapReferences(a, middle, high - 1);
            var pivot = a[high - 1];

            int i;
            int j;
            for (i = low, j = high - 1; ;) {
                do {
                    ++i;
                    ++count;
                } while (a[i].compareTo(pivot) < 0);

                do {
                    --j;
                    ++count;
                } while (pivot.compareTo(a[j]) < 0);

                if (i >= j)
                    break;

                swapReferences(a, i, j);
            }

            swapReferences( a, i, high - 1 );

            count += quicksort( a, low, i - 1 );    // Sort small elements
            count += quicksort( a, i + 1, high );   // Sort large elements
        }
        return count;
    }

    private static long insertionSort( Comparable [ ] a, int low, int high ) {
       long count = 0;
        for (var p = low + 1; p <= high; ++p) {
            var tmp = a[p];
            var j = p;

            for ( ; j > 0; j--) {
               if (j > low && ++count >= 0 && less(tmp, a[j-1])){
                   exch(a, j, j-1);
               }
               else{
                    a[j] = tmp;
                    break;
               }
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
