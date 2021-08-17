package megaSena;

import java.util.Arrays;
import java.util.Scanner;

public class Sorteio {

    public static void main(String[] args) {

        int n = 6;                                               // tamanho do vetor
        int a[] = new int[n];                                    // declarando e alocando espaço para o vetor "a"
        int i;

        for (i = 0; i < n; i++) {
            a[i] = (int) Math.round(Math.random() * 60);         // sorteia números de 0 a 60

            for (int j = 1; j < n; j++) {                        // sorteia o vetor a partir da segunda casa
                a[j] = (int) Math.round(Math.random() * 60);     // sorteia números de 0 a 60

                if (a[i] == a[j]) {                              // verifica se existem números repetidos
                    a[j] = (int) Math.round(Math.random() * 60); // caso houverem, serão resorteados
                } else {
                    a[i] = a[j];                                 // para depois serem guardados no vetor
                }
            }
        }

        System.out.println(".:SEJA BEM VINDO À NOSSA LOTERIA:.");
        System.out.println("Digite 06 dezenas entre 01 e 60");

        Scanner ler = new Scanner(System.in);                    // chama o teclado

        int b[] = new int[n];                                    // declarando o vetor que vai receber os números

        for (int k = 0; k < n; k++) {
            b[k] = ler.nextInt();                                // recebe do teclado a cada repetição
        }

        int contador = 0;                                        // variável para contar acertos

        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[j] == a[i]) {                              // compara sorteados com digitados
                    contador++;                                  // aumenta a cada acerto
                }
            }
        }

        Arrays.sort(a);                                          // ordena sorteados
        System.out.println("Os valores sorteados foram" + Arrays.toString(a));
        Arrays.sort(b);                                          // ordena digitados
        System.out.println("Os valores digitados foram" + Arrays.toString(b));
        System.out.println("Voce acertou: " + contador + " números");

        if (contador == 6) {
            System.out.println("PARABÉNS! VOCÊ É O GANHADOR");
        } else {
            System.out.println("Não foi dessa vez...");
        }
    }
}
