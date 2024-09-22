import java.util.Random;

public class Ordenacao {

    public static int[] bubbleSort(int[] array){
        int n = array.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                comparacoes++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocas++;
                }
            }
        }
        return new int[] {comparacoes, trocas};
    }

    public static int[] selectionSort(int[] array) {
        int n = array.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                trocas++;
                int temp = array[min_idx];
                array[min_idx] = array[i];
                array[i] = temp;
            }
        }
        return new int[] {comparacoes, trocas};
    }


    public static int[] insertionSort(int[] array){
        int n = array.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                comparacoes++;
                array[j + 1] = array[j];
                trocas++;
                j = j - 1;
            }
            comparacoes++;
            array[j + 1] = key;
        }
        return new int[] {comparacoes, trocas};
    }

    //Preciso ajustar merge e quick

    public static void mergeSort(int[] array, int inicio, int fim){
        int n = array.length;

        if (inicio < fim){
            int meio = (inicio + fim)/2;
            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim){
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++)
            esquerda[i] = vetor[inicio + i];
        for (int j = 0; j < n2; j++)
            direita[j] = vetor[meio + 1 + j];

        int i = 0, j = 0;
        int k = inicio;
        while(i < n1 && j < n2){
            if (esquerda[i] <= direita[j]){
                vetor[k] = esquerda[i];
                i++;
            }else{
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2){
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] vetor, int inicio, int fim){
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, indicePivo -1);
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private  static int particionar(int[] vetor, int inicio, int fim){
        int pivo = vetor[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++){
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];

        return i + 1;
    }


    public static int[] gerarArrayOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }


    public static int[] gerarArrayOrdenadoInversamente(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i - 1;
        }
        return array;
    }


    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho);
        }
        return array;
    }
}
