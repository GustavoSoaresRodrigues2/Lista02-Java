package Pilhas;

import java.util.Scanner;

public class exer03 {
    private char[] elementos;
    private int topo;

    public exer03() {
        this.elementos = new char[10];
        this.topo = -1;
    }

    public void inserirElemento(char elemento) {
        if (topo < 9) {
            topo++;
            elementos[9 - topo] = elemento;
            System.out.println("Elemento inserido com sucesso.");
        } else {
            System.out.println("A pilha está cheia. Não é possível inserir mais elementos.");
        }
    }

    public void consultarElemento() {
        if (topo >= 0) {
            System.out.println("Último elemento inserido na pilha: " + elementos[9 - topo]);
            System.out.println("Quantidade de elementos na pilha: " + (topo + 1));
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public void retirarElemento() {
        if (topo >= 0) {
            System.out.println("Elemento retirado: " + elementos[9 - topo]);
            topo--;
        } else {
            System.out.println("A pilha está vazia. Não há elementos para retirar.");
        }
    }

    public static void main(String[] args) {
        exer03 pilha = new exer03();
        Scanner scanner = new Scanner(System.in);
        int opcao;

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
                    char elemento = scanner.next().charAt(0);
                    pilha.inserirElemento(elemento);
                    break;
                case 2:
                    pilha.consultarElemento();
                    break;
                case 3:
                    pilha.retirarElemento();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 4);
        
        scanner.close();
    }
}
