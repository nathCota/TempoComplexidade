public class App {
    public static void main(String[] args) throws Exception {
        int tam = 10000;
        int numTests = 10;
        long totalRandomTime = 0;
        long totalSortedTime = 0;

        for (int test = 0; test < numTests; test++) {
            int x;
            int vet[] = new int[tam];
            int quick[] = new int[tam];

            for (int i = 0; i < tam; i++) {
                x = (int) Math.round(Math.random() * 100);
                vet[i] = x;
                quick[i] = x;
            }

            System.out.println("===============================================================================");
            System.out.println("TESTE COM O METODO QUICKSORT Aleatorio - Test " + (test + 1));

            long inicialRandom = System.currentTimeMillis();

            quickSort(quick, 0, tam - 1);

            long finalRandom = System.currentTimeMillis();
            long randomTime = finalRandom - inicialRandom;
            totalRandomTime += randomTime;

            System.out.println("Executado em = " + randomTime + " ms");

            System.out.println("===============================================================================");
            System.out.println("TESTE COM O METODO QUICKSORT Ordenado - Test" + (test + 1));

            long inicialSorted = System.currentTimeMillis();

            quickSort2(vet, 0, tam - 1);

            long finalSorted = System.currentTimeMillis();
            long sortedTime = finalSorted - inicialSorted;
            totalSortedTime += sortedTime;

            System.out.println("Executado em = " + sortedTime + " ms");
        }

        System.out.println("===============================================================================");
        System.out.println("Média de tempo  método QUICKSORT Aleatorio: " + (totalRandomTime / numTests) + " ms");
        System.out.println("Média de tempo  método QUICKSORT Ordenado: " + (totalSortedTime / numTests) + " ms");

    }

    // Quicksort Aleatorio

    public static void quickSort(int[] quick, int inicio, int tam) {
        if (inicio < tam) {
            int posicaoPivo = separar(quick, inicio, tam);
            quickSort(quick, inicio, posicaoPivo - 1);
            quickSort(quick, posicaoPivo + 1, tam);
        }
    }

    private static int separar(int[] quick, int inicio, int tam) {
        int pivo = quick[inicio];
        int i = inicio + 1, f = tam;
        while (i <= f) {
            if (quick[i] <= pivo)
                i++;
            else if (pivo < quick[f])
                f--;
            else {
                int troca = quick[i];
                quick[i] = quick[f];
                quick[f] = troca;
                i++;
                f--;
            }
        }
        quick[inicio] = quick[f];
        quick[f] = pivo;
        return f;
    }
    // Quicksort Ordenado

    public static void quickSort2(int[] vet, int inic, int tam) {
        if (inic < tam) {
            int Pivo = separar2(vet, inic, tam);
            quickSort(vet, inic, Pivo - 1);
            quickSort(vet, Pivo + 1, tam);
        }
    }

    private static int separar2(int[] vet, int inic, int tam) {
        int pivo = vet[inic];
        int i = inic + 1, f = tam;
        while (i <= f) {
            if (vet[i] <= pivo)
                i++;
            else if (pivo < vet[f])
                f--;
            else {
                int troca = vet[i];
                vet[i] = vet[f];
                vet[f] = troca;
                i++;
                f--;
            }
        }
        vet[inic] = vet[f];
        vet[f] = pivo;
        return f;

    }
}
