/*
    31) Elaborar um programa em linguagem Java capaz de armazenar itens numéricos e inteiros em NÓS de uma estrutura de dados do tipo ÁRVORE BINÁRIA. O operador deverá digitar os valores para os itens seguindo a regra de Acesso PRÉ-ORDENADO e apresentá-los seguindo o Acesso PRÉ-ORDENADO.
*/

package ArvoreBinaria;

import java.util.Scanner;

// Definição da classe para o Nó da Árvore Binária
class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

// Classe para a Árvore Binária
class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para inserir um valor na árvore
    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        return no;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Método para percorrer a árvore em pré-ordem
    private void percorrerPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percorrerPreOrdemRecursivo(no.esquerda);
            percorrerPreOrdemRecursivo(no.direita);
        }
    }

    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(raiz);
        System.out.println();
    }
}

// Classe principal que contém o método main
public class ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os valores dos nós da árvore (pré-ordenado):");
        String input = scanner.nextLine();
        String[] valoresStr = input.split("\\s+");
        int[] valores = new int[valoresStr.length];

        for (int i = 0; i < valoresStr.length; i++) {
            valores[i] = Integer.parseInt(valoresStr[i]);
        }

        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserir os valores na árvore
        for (int valor : valores) {
            arvore.inserir(valor);
        }

        // Apresentar os valores na árvore em pré-ordem
        System.out.println("Valores na árvore (pré-ordenado):");
        arvore.percorrerPreOrdem();

        scanner.close();
    }
}

