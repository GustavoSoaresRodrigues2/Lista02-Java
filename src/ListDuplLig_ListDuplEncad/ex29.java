package ListDuplLig_ListDuplEncad;
import javax.swing.*;

public class ex29 {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        String frase = JOptionPane.showInputDialog("Digite a frase:");
        for (char c : frase.toCharArray()) {
            lista.inserir(c);
        }

        char caractere = JOptionPane.showInputDialog("Digite o caractere a ser removido:").charAt(0);

        lista.remover(caractere);

        String forwardResult = lista.isEmpty() ? "Lista Vazia" : lista.forwardTraversal().replaceAll("\\s+", " ");
        JOptionPane.showMessageDialog(null, "Frase resultante (do primeiro nó ao último):\n" + forwardResult);

        String reverseResult = lista.isEmpty() ? "Lista Vazia" : lista.reverseTraversal().replaceAll("\\s+", " ");
        JOptionPane.showMessageDialog(null, "Frase resultante (do último nó ao primeiro):\n" + reverseResult);
    }
}

class No {
    char data;
    No anterior;
    No proximo;

    No(char data) {
        this.data = data;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    No primeiro;
    No ultimo;

    ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    void inserir(char data) {
        No newNode = new No(data);
        if (primeiro == null) {
            primeiro = newNode;
            ultimo = newNode;
        } else {
            ultimo.proximo = newNode;
            newNode.anterior = ultimo;
            ultimo = newNode;
        }
    }

    void remover(char data) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.data == data) {
                if (atual == primeiro) {
                    primeiro = primeiro.proximo;
                    if (primeiro != null) {
                        primeiro.anterior = null;
                    }
                } else if (atual == ultimo) {
                    ultimo = ultimo.anterior;
                    ultimo.proximo = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
            }
            atual = atual.proximo;
        }
    }

    String forwardTraversal() {
        StringBuilder result = new StringBuilder();
        No atual = primeiro;
        while (atual != null) {
            result.append(atual.data);
            atual = atual.proximo;
        }
        return result.toString();
    }
    
    String reverseTraversal() {
        StringBuilder result = new StringBuilder();
        No atual = ultimo;
        while (atual != null) {
            result.append(atual.data);
            atual = atual.anterior;
        }
        return result.toString();
    }
    
    boolean isEmpty() {
        return primeiro == null;
    }
}