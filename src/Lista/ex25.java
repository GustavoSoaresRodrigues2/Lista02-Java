package Lista;

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
    private No corrente;

    public ListaSimplesmenteEncadeada() {
        this.inicio = null;
        this.corrente = null;
    }

    public void inicializarLista() {
        corrente = inicio;
        System.out.println("Lista Inicializada.");
    }

    public void apresentarProximoNo() {
        if (corrente == null) {
            System.out.println("Lista Encerrada.");
        } else if (corrente.proximo == null) {
            System.out.println("Último Nó da Lista: " + corrente.elemento);
            corrente = null;
        } else {
            System.out.println("Conteúdo do Próximo Nó: " + corrente.elemento);
            corrente = corrente.proximo;
        }
    }

    public void inserirNo(String elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            if (corrente != null) {
                novoNo.proximo = corrente.proximo;
                corrente.proximo = novoNo;
            } else {
                No temp = inicio;
                while (temp.proximo != null) {
                    temp = temp.proximo;
                }
                temp.proximo = novoNo;
            }
        }
        inicializarLista();
    }

    public void removerUltimoNo() {
        if (inicio == null || inicio.proximo == null) {
            System.out.println("Não há nó a ser Eliminado.");
        } else {
            No temp = inicio;
            No anterior = null;
            while (temp.proximo != null) {
                anterior = temp;
                temp = temp.proximo;
            }
            System.out.println("Nó Eliminado: " + temp.elemento);
            anterior.proximo = null;
        }
        inicializarLista();
    }
}

public class ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();

        char opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("a) Inicializar a lista");
            System.out.println("b) Apresentar o conteúdo do próximo nó");
            System.out.println("c) Inserir um nó na posição corrente");
            System.out.println("d) Eliminar o último nó válido apresentado");
            System.out.println("e) Sair");
            System.out.print("Opção: ");
            opcao = scanner.next().charAt(0);
            switch (opcao) {
                case 'a':
                    lista.inicializarLista();
                    break;
                case 'b':
                    lista.apresentarProximoNo();
                    break;
                case 'c':
                    System.out.print("Digite o elemento do novo nó: ");
                    String elementoInserir = scanner.next();
                    lista.inserirNo(elementoInserir);
                    break;
                case 'd':
                    lista.removerUltimoNo();
                    break;
                case 'e':
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 'e');
    }
}
