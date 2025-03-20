package sorts;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements ISorter<T> {
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
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arrayCopy[j].compareTo(arrayCopy[j + 1]) > 0) {
                    T temp = arrayCopy[j];
                    arrayCopy[j] = arrayCopy[j + 1];
                    arrayCopy[j + 1] = temp;
                    swaps++;
                }
            }
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