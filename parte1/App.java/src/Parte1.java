public class App {
    public static void main(String[] args) throws Exception {
        int[] tamanhos = { 62500, 125000, 250000, 375000 };

        for (int tamanho : tamanhos) {
            int[][] vetores = new int[50][tamanho];
            int[][] bolhas = new int[50][tamanho];
            int[][] quicks = new int[50][tamanho];

            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < tamanho; j++) {
                    int x = (int) Math.round(Math.random() * 40);
                    vetores[i][j] = x;
                    bolhas[i][j] = x;
                    quicks[i][j] = x;
                }
            }

            System.out.println("Tamanho do vetor: " + tamanho);
            System.out.println("=====================================");
            
            long tempoTotalBolha = 0;
            long tempoTotalQuick = 0;

            System.out.println("TESTE COM O METODO BOLHA");
            for (int i = 0; i < 50; i++) {

                long tempoInicialBolha = System.currentTimeMillis();
                Bolha(bolhas[i], tamanho);
                long tempoFinalBolha = System.currentTimeMillis();
                long tempoExecucaoBolha = tempoFinalBolha - tempoInicialBolha;
                tempoTotalBolha += tempoExecucaoBolha;
                System.out.println("Tempo de execução em ms: " + tempoExecucaoBolha );
            }

            System.out.println("TESTE COM O METODO QUICKSORT");
            for (int i = 0; i < 50; i++) {
                long tempoInicialQuick = System.currentTimeMillis();
                quickSort(quicks[i], 0, tamanho - 1);
                long tempoFinalQuick = System.currentTimeMillis();
                long tempoExecucaoQuick = tempoFinalQuick - tempoInicialQuick;
                tempoTotalQuick += tempoExecucaoQuick;
                System.out.println("Tempo de execução em ms: " + tempoExecucaoQuick );
            }

            long mediaTempoBolha = tempoTotalBolha / 50;
            long mediaTempoQuick = tempoTotalQuick / 50;

            System.out.println("Média de tempo para Algoritmo Bolha: " + mediaTempoBolha + " ms");
            System.out.println("Média de tempo para Algoritmo QuickSort: " + mediaTempoQuick + " ms");
            System.out.println("=====================================");
            

        }
    }

    // Metodo Bolha
    public static void Bolha(int[] bolha, int tam) {
        int aux;
        for (int i = 0; i < tam; ++i) {
            for (int j = i; j < tam; ++j) {
                if (bolha[i] > bolha[j]) {
                    aux = bolha[i];
                    bolha[i] = bolha[j];
                    bolha[j] = aux;
                }
            }
        }
    }

    // Quicksort

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
}
