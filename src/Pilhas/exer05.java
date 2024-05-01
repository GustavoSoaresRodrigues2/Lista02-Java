package Pilhas;

import java.util.Scanner;

public class exer05 {

    private static final int TAMANHO_MAXIMO = 5;
    private static int[] vetor = new int[TAMANHO_MAXIMO];
    private static int topo = -1; // Índice do topo da pilha

    public void inserirElemento(int elemento) {
        if (topo < TAMANHO_MAXIMO - 1) {
            topo++;
            vetor[topo] = elemento;
            System.out.println("Elemento '" + elemento + "' inserido na pilha.");
        } else {
            System.out.println("A pilha está cheia, não é possível inserir mais elementos.");
        }
    }

    public void consultarElemento() {
        if (topo >= 0) {
            System.out.println("Último elemento inserido na pilha: " + vetor[topo]);
            System.out.println("Quantidade de elementos na pilha: " + (topo + 1));
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public void retirarElemento() {
        if (topo >= 0) {
            int elemento = vetor[topo];
            topo--;
            System.out.println("Elemento '" + elemento + "' retirado da pilha.");
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public static int soma() {
        if (topo >= 1) {
            int valorum = vetor[topo];
            int valordois = vetor[topo - 1];
            int resultado = valorum + valordois;
            // Substituir os dois últimos elementos pelo resultado
            vetor[topo - 1] = resultado;
            topo--;
            return resultado;
        } else {
            System.out.println("Não há elementos suficientes na pilha para realizar a operação.");
            return 0;
        }
    }

    public static int subtracao() {
        if (topo >= 2) {
            // Obter o último elemento da pilha
            int valorum = soma();
            // Obter o terceiro elemento a partir do topo da pilha
            int valordois = vetor[topo - 2];
            // Calcular a subtração
            int resultado = valordois - valorum;
            // Substituir o terceiro elemento a partir do topo pelo resultado
            vetor[topo - 2] = resultado;
            // Reduzir o topo duas vezes (remoção de 2 elementos: topo e topo - 1)
            topo -= 2;
            return resultado;
        } else {
            // Não há elementos suficientes para realizar a operação
            System.out.println("Não há elementos suficientes na pilha para realizar a operação.");
            return 0;
        }
    }

    public static int multiplicacao() {
        if (topo >= 1) {
            int valorum = subtracao();
            int valordois = vetor[topo - 3];
            int resultado = valorum * valordois;
            // Substituir os dois últimos elementos pelo resultado
            vetor[topo - 1] = resultado;
            topo--;
            return resultado;
        } else {
            System.out.println("Não há elementos suficientes na pilha para realizar a operação.");
            return 0;
        }
    }

    public static int divisao() {
        if (topo >= 1) {
            int valorum = multiplicacao();
            int valordois = vetor[topo - 4];
            // Verifica divisão por zero
            if (valorum == 0) {
                System.out.println("Erro: divisão por zero.");
                return 0;
            }
            int resultado = valordois / valorum;
            // Substituir os dois últimos elementos pelo resultado
            vetor[topo - 1] = resultado;
            topo--;
            return resultado;
        } else {
            System.out.println("Não há elementos suficientes na pilha para realizar a operação.");
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exer05 pilha = new exer05();

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Elemento");
            System.out.println("2. Consultar Elemento");
            System.out.println("3. Retirar Elemento");
            System.out.println("4. Sair");
            System.out.println("5. Somar Elementos");
            System.out.println("6. Subtrair Elementos");
            System.out.println("7. Multiplicar Elementos");
            System.out.println("8. Dividir Elementos");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido na pilha: ");
                    int elemento = scanner.nextInt();
                    pilha.inserirElemento(elemento);
                    break;
                case 2:
                    pilha.consultarElemento();
                    break;
                case 3:
                    pilha.retirarElemento();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                case 5:
                    System.out.println("Soma: " + soma());
                    break;
                case 6:
                    System.out.println("Subtração: " + subtracao());
                    break;
                case 7:
                    System.out.println("Multiplicação: " + multiplicacao());
                    break;
                case 8:
                    System.out.println("Divisão: " + divisao());
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
