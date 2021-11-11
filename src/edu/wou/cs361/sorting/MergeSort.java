package edu.wou.cs361.sorting;

public class MergeSort implements ISort {
    @Override
    public long sort(final Comparable[] array) {
        if (array == null) throw new IllegalArgumentException();

        long count = 0;
        var tmpArray = new Comparable[array.length];
        count += mergeSort(array, tmpArray, 0, array.length - 1);

        return count;
    }


    private static long mergeSort(Comparable [] a, Comparable [] tmpArray,
                                  int left, int right) {
        long count = 0;
        if (left < right) {
            int center = ( left + right ) / 2;
            count += mergeSort(a, tmpArray, left, center);
            count += mergeSort(a, tmpArray, center + 1, right);
            return count += merge(a, tmpArray, left, center + 1, right);
        }
       return count;
    }

    private static long merge(Comparable [] a, Comparable [ ] tmpArray,
                              int leftPos, int rightPos, int rightEnd) {
        long count = 0;
        var leftEnd = rightPos - 1;
        var tmpPos = leftPos;
        var numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            ++count;
            if (a[leftPos].compareTo(a[rightPos]) <= 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];}

        while (leftPos <= leftEnd)   {
            tmpArray[tmpPos++] = a[leftPos++];}

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];}

        for (var i = 0; i < numElements; i++, --rightEnd){
            a[rightEnd] = tmpArray[rightEnd];
        }
         return count;
    }
}
