package Lista;

import java.util.Scanner;

class No {
    char caractere;
    No proximo;

    public No(char caractere) {
        this.caractere = caractere;
        this.proximo = null;
    }
}

class ListaSimplesmenteEncadeada {
    private No inicio;

    public ListaSimplesmenteEncadeada() {
        this.inicio = null;
    }

    public void inserir(char caractere) {
        No novoNo = new No(caractere);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novoNo;
        }
    }

    public void removerCaractere(char caractere) {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        No atual = inicio;
        No anterior = null;
        while (atual != null) {
            if (atual.caractere == caractere) {
                if (anterior == null) {
                    inicio = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    public String obterFrase() {
        StringBuilder frase = new StringBuilder();
        No atual = inicio;
        while (atual != null) {
            frase.append(atual.caractere);
            atual = atual.proximo;
        }
        return frase.toString();
    }
}

public class ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();

        System.out.print("Digite uma frase: ");
        String entrada = scanner.nextLine();

        for (char c : entrada.toCharArray()) {
            lista.inserir(c);
        }

        System.out.print("Digite o caractere a ser removido: ");
        char caractereRemover = scanner.next().charAt(0);

        lista.removerCaractere(caractereRemover);

        System.out.println("Frase resultante: " + lista.obterFrase());
    }
}
