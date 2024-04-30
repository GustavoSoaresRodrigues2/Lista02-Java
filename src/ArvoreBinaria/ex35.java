/*
    35) Elaborar um programa em linguagem Java que apresente ao operador o menu abaixo e execute as funções descritas nele: 

    A- Inserir Nó na Árvore (Acesso Pré-Ordenado); 
    B- Apresentar Árvore; 
    B- Eliminar Nó da Árvore (Digitado o Conteúdo do Nó); 
    C- Sair. 

    Observação: O item C deve solicitar a digitação de um Nó, que se existir na árvore, será ser eliminado. Informar todas as possibilidades em tela. Quando eliminar um nó pai que tenha apenas um dos dois nós filhos, esse nó filho assumirá o lugar do nó pai. Quando eliminar um nó pai que tenha os dois nós filhos, o nó filho da direita assumirá o lugar do nó pai e o nó filho da esquerda deverá ser alocado corretamente ao novo nó pai.
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

    // Método para eliminar um nó da árvore
    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    private No removerRecursivo(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor == no.valor) {
            if (no.esquerda == null && no.direita == null) {
                return null;
            }
            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }

            No sucessor = encontrarMinimo(no.direita);
            no.valor = sucessor.valor;
            no.direita = removerRecursivo(no.direita, sucessor.valor);
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = removerRecursivo(no.esquerda, valor);
            return no;
        }

        no.direita = removerRecursivo(no.direita, valor);
        return no;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }
}

// Classe principal que contém o método main
public class ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        char opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("A- Inserir Nó na Árvore (Acesso Pré-Ordenado)");
            System.out.println("B- Apresentar Árvore");
            System.out.println("C- Eliminar Nó da Árvore (Digitado o Conteúdo do Nó)");
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
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    if (arvore.buscar(valorRemover)) {
                        arvore.remover(valorRemover);
                        System.out.println("O nó com valor " + valorRemover + " foi removido.");
                    } else {
                        System.out.println("O valor " + valorRemover + " não está na árvore.");
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

