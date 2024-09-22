import java.util.Random;

public class Main {
    public static void main(String[] args) {

    int[] array = new int[100000];
    Random random = new Random();
        for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(1000);
    }

    int[] resultados0 = Ordenacao.selectionSort(Ordenacao.gerarArrayOrdenado(100000));
    int[] resultadosi = Ordenacao.selectionSort(Ordenacao.gerarArrayOrdenadoInversamente(100000));
    int[] resultadosA = Ordenacao.selectionSort(Ordenacao.gerarArrayAleatorio(100000));

        System.out.println("Usando o Método Selection Sort ");
        System.out.println("Foram feitas " + resultados0[0] + " comparações usando array ordenado.");
        System.out.println("Foram feitas " + resultados0[1] + " trocas usando array ordenado.");
        System.out.println("Foram feitas " + resultadosi[0] + " comparações usando array em ordem inversa.");
        System.out.println("Foram feitas " + resultadosi[1] + " trocas usando array em ordem inversa.");
        System.out.println("Foram feitas " + resultadosA[0] + " comparações usando array em ordem aleatória.");
        System.out.println("Foram feitas " + resultadosA[1] + " trocas usando array em ordem aleatória.");


        //Preciso ajustar o tempo
        double tempoInicio = System.nanoTime();
        double tempoFim = System.nanoTime();
        double tempoNano = tempoFim - tempoInicio;
        double tempoMili = tempoNano / 1_000_000;
        double tempoSeg = tempoNano / 1_000_000_000;
        System.out.println("Tempo em segundos: " + tempoSeg);
        System.out.println("Tempo em milissegundos: " + tempoMili);
    }
}
