package sorts;

import java.util.Arrays;

public class InsertionSort<T extends Comparable<T>> implements ISorter<T> {
    private int comparisons = 0;
    private int swaps = 0;
    private long time = 0;

    @Override
    public T[] sort(T[] dados) {
        T[] arrayCopy = Arrays.copyOf(dados, dados.length);
        int n = arrayCopy.length;
        comparisons = 0;
        swaps = 0;
        
        long start = System.nanoTime();
        for (int i = 1; i < n; i++) {
            T key = arrayCopy[i];
            int j = i - 1;
            while (j >= 0 && arrayCopy[j].compareTo(key) > 0) {
                comparisons++;
                arrayCopy[j + 1] = arrayCopy[j];
                j--;
                swaps++;
            }
            arrayCopy[j + 1] = key;
        }
        time = System.nanoTime() - start;
        return arrayCopy;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    @Override
    public int getSwaps() {
        return swaps;
    }

    @Override
    public long getTime() {
        return time;
    }
}