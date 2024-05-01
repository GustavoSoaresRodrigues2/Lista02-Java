package Pilhas;

import java.util.Scanner;

public class exer01 {

    private static final int TAMANHO_MAXIMO = 10;
    private char[] vetor = new char[TAMANHO_MAXIMO];
    private int topo = -1; // Índice do topo da pilha

    public void inserirElemento(char elemento) {
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
            char elemento = vetor[topo];
            topo--;
            System.out.println("Elemento '" + elemento + "' retirado da pilha.");
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exer01 pilha = new exer01();

        int opcao;
        char elemento;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Elemento");
            System.out.println("2. Consultar Elemento");
            System.out.println("3. Retirar Elemento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido na pilha: ");
                    elemento = scanner.next().charAt(0);
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
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}