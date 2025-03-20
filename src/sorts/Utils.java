package sorts;
 
 public class Utils<T extends Comparable<T>> {
     public void swap(T[] dados, int i, int j) {
         T temp = dados[i];
         dados[i] = dados[j];
         dados[j] = temp;
     }
 }