import java.util.Random;
import sorts.BubbleSort;
import sorts.InsertionSort;

public class App {
    static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        36 };
    static Random aleatorio = new Random(42);

    
    static int codigo1(int[] vetor) {
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i]%2;
        }
        return resposta;
    }

    
    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }

        }
        return contador;
    }

    
    static void codigo3(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    
    static int codigo4(int n) {
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
        
    }
    public static void main(String[] args) {
        long inicio, fim;
        int operacoes;
    
        
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
    
            inicio = System.nanoTime();
            operacoes = codigo1(vetor);
            fim = System.nanoTime();
            System.out.println("codigo1 - " + tamanho + " - " + operacoes + " - " + (fim - inicio));
    
            inicio = System.nanoTime();
            operacoes = codigo2(vetor);
            fim = System.nanoTime();
            System.out.println("codigo2 - " + tamanho + " - " + operacoes + " - " + (fim - inicio));
        }
    
        
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
    
            operacoes = 0;
            inicio = System.nanoTime();
            for (int i = 0; i < vetor.length - 1; i++) {
                int menor = i;
                for (int j = i + 1; j < vetor.length; j++) {
                    operacoes++; 
                    if (vetor[j] < vetor[menor])
                        menor = j;
                }
                
                int temp = vetor[i];
                vetor[i] = vetor[menor];
                vetor[menor] = temp;
                operacoes += 3; 
            }
            fim = System.nanoTime();
            System.out.println("codigo3 - " + tamanho + " - " + operacoes + " - " + (fim - inicio));
        }
    
        
        for (int tamanho : tamanhosTestePequeno) {
            inicio = System.nanoTime();
            operacoes = codigo4(tamanho);
            fim = System.nanoTime();
            System.out.println("codigo4 - " + tamanho + " - " + operacoes + " - " + (fim - inicio));
        }

        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        for (int tamanho : tamanhosTesteMedio) {
            Integer[] vetor = new Integer[tamanho];
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = aleatorio.nextInt(1, tamanho / 2);
            }

            bubbleSort.sort(vetor);
            System.out.println("BubbleSort - " + tamanho + " - Comparisons: " + bubbleSort.getComparisons() + " - Swaps: " + bubbleSort.getSwaps() + " - Time: " + bubbleSort.getTime());

            insertionSort.sort(vetor);
            System.out.println("InsertionSort - " + tamanho + " - Comparisons: " + insertionSort.getComparisons() + " - Swaps: " + insertionSort.getSwaps() + " - Time: " + insertionSort.getTime());
        }
    }


    }
  
