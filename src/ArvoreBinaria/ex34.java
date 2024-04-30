/*
    34) Elaborar um programa em linguagem Java que apresente ao operador o menu abaixo e execute as funções descritas nele: 

    A- Inserir Nó na Árvore (Acesso Pré-Ordenado); 
    B- Apresentar Árvore; 
    C- Buscar Nó na Árvore; 
    D- Sair. 

    Obs.: Os itens A e B são semelhantes ao exercício anterior. O item C deve informar se o nó solicitado está ou não na árvore binária.
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

    // Método para apresentar a árvore em pré-ordem
    private void apresentarPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            apresentarPreOrdemRecursivo(no.esquerda);
            apresentarPreOrdemRecursivo(no.direita);
        }
    }

    public void apresentarPreOrdem() {
        apresentarPreOrdemRecursivo(raiz);
        System.out.println();
    }

    // Método para buscar um valor na árvore
    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        }

        if (valor < no.valor) {
            return buscarRecursivo(no.esquerda, valor);
        } else {
            return buscarRecursivo(no.direita, valor);
        }
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
}

// Classe principal que contém o método main
public class ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        char opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("A- Inserir Nó na Árvore (Acesso Pré-Ordenado)");
            System.out.println("B- Apresentar Árvore");
            System.out.println("C- Buscar Nó na Árvore");
            System.out.println("D- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'A':
                case 'a':
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    break;
                case 'B':
                case 'b':
                    System.out.println("Árvore:");
                    arvore.apresentarPreOrdem();
                    break;
                case 'C':
                case 'c':
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBuscar = scanner.nextInt();
                    if (arvore.buscar(valorBuscar)) {
                        System.out.println("O valor " + valorBuscar + " está na árvore.");
                    } else {
                        System.out.println("O valor " + valorBuscar + " não está na árvore.");
                    }
                    break;
                case 'D':
                case 'd':
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
            }
        } while (opcao != 'D' && opcao != 'd');

        scanner.close();
    }
}

