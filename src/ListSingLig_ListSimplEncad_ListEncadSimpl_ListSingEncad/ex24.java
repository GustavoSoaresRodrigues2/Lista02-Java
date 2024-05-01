package ListSingLig_ListSimplEncad_ListEncadSimpl_ListSingEncad;

import java.util.Scanner;

class No {
    String elemento;
    No proximo;

    public No(String elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}

class ListaSimplesmenteEncadeada {
    private No inicio;

    public ListaSimplesmenteEncadeada() {
        this.inicio = null;
    }

    public void inserirStringElemento(String elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novoNo;
        }
        System.out.println("Elemento \"" + elemento + "\" inserido no final da lista.");
    }

    public void apresentarLista() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
        } else {
            No temp = inicio;
            System.out.println("Conteúdo da lista:");
            while (temp != null) {
                System.out.println(temp.elemento);
                temp = temp.proximo;
            }
        }
    }

    public void removerElemento() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
        } else if (inicio.proximo == null) {
            System.out.println("Elemento \"" + inicio.elemento + "\" removido.");
            inicio = null;
        } else {
            No temp = inicio;
            No anterior = null;
            while (temp.proximo != null) {
                anterior = temp;
                temp = temp.proximo;
            }
            System.out.println("Elemento \"" + temp.elemento + "\" removido.");
            anterior.proximo = null;
        }
    }
}

public class ex24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();

        char opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inserir um novo nó");
            System.out.println("b) Apresentar todos os nós");
            System.out.println("c) Remover o último nó");
            System.out.println("d) Sair");
            System.out.print("Opção: ");
            opcao = scanner.next().charAt(0);
            switch (opcao) {
                case 'a':
                    System.out.print("Digite o elemento a ser inserido: ");
                    String elementoInserir = scanner.next();
                    lista.inserirStringElemento(elementoInserir);
                    break;
                case 'b':
                    lista.apresentarLista();
                    break;
                case 'c':
                    lista.removerElemento();
                    break;
                case 'd':
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 'd');
    }
}
