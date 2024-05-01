package Pilhas;

import java.util.EmptyStackException;
import java.util.Scanner;

public class exer02 {
    private char[] vetor;
    private int topo;

    public exer02(int tamanhoMaximo) {
        vetor = new char[tamanhoMaximo];
        topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == vetor.length - 1;
    }

    public void inserirElemento(char elemento) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia, não é possível inserir mais elementos.");
            return;
        }
        topo++;
        vetor[topo] = elemento;
        System.out.println("Elemento '" + elemento + "' inserido na pilha.");
    }

    public char consultarElemento() {
        if (estaVazia()) {
            throw new EmptyStackException();
        }
        return vetor[topo];
    }

    public char retirarElemento() {
        if (estaVazia()) {
            throw new EmptyStackException();
        }
        char elemento = vetor[topo];
        topo--;
        System.out.println("Elemento '" + elemento + "' retirado da pilha.");
        return elemento;
    }

    public int tamanho() {
        return topo + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exer02 pilha = new exer02(10);

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
                    try {
                        char ultimoElemento = pilha.consultarElemento();
                        System.out.println("Último elemento inserido na pilha: " + ultimoElemento);
                        System.out.println("Quantidade de elementos na pilha: " + pilha.tamanho());
                    } catch (Exception e) {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 3:
                    try {
                        char elementoRetirado = pilha.retirarElemento();
                        System.out.println("Elemento retirado: " + elementoRetirado);
                    } catch (Exception e) {
                        System.out.println("A pilha está vazia.");
                    }
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
