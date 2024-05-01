package ListDuplLig_ListDuplEncad;
import javax.swing.*;

public class ex27 {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        char choice;

        do {
            String menu = "Menu:\n"
                        + "1 - Inserir novo nó\n"
                        + "2 - Remover último nó\n"
                        + "3 - Mostrar conteúdo do nó atual\n"
                        + "4 - Mostrar conteúdo do próximo nó\n"
                        + "5 - Mostrar conteúdo do nó anterior\n"
                        + "6 - Sair\n\n"
                        + "Escolha uma opção:";

            choice = JOptionPane.showInputDialog(null, menu).charAt(0);

            switch (choice) {
                case '1':
                    int item = Integer.parseInt(JOptionPane.showInputDialog("Digite o item a ser inserido:"));
                    lista.insert(item);
                    break;
                case '2':
                    lista.remover();
                    break;
                case '3':
                    JOptionPane.showMessageDialog(null, lista.itemAtual());
                    break;
                case '4':
                    JOptionPane.showMessageDialog(null, lista.proxItem());
                    break;
                case '5':
                    JOptionPane.showMessageDialog(null, lista.itemAnterior());
                    break;
                case '6':
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (choice != '6');
    }
}

class No {
    int item;
    No anterior;
    No proximo;

    No(int item) {
        this.item = item;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada{
    No atual;

    ListaDuplamenteEncadeada() {
        this.atual = null;
    }

    void insert(int item) {
        No newNode = new No(item);
        if (atual == null) {
            atual = newNode;
        } else {
            newNode.anterior = atual;
            atual.proximo = newNode;
            atual = newNode;
        }
    }

    void remover() {
        if (atual != null) {
            atual = atual.anterior;
            if (atual != null)
                atual.proximo = null;
        }
    }

    String itemAtual() {
        if (atual != null) {
            return "Item atual: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }

    String proxItem() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            return "Próximo item: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }

    String itemAnterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            return "Item anterior: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }
}

