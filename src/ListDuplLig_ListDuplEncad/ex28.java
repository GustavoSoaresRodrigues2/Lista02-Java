package ListDuplLig_ListDuplEncad;
import javax.swing.*;
public class ex28 {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        char choice;

        do {
            String menu = "Menu:\n"
                        + "1 - Inicializar a lista\n"
                        + "2 - Apresentar próximo nó\n"
                        + "3 - Apresentar nó anterior\n"
                        + "4 - Inserir nó na posição corrente\n"
                        + "5 - Eliminar último nó válido\n"
                        + "6 - Sair\n\n"
                        + "Escolha uma opção:";

            choice = JOptionPane.showInputDialog(null, menu).charAt(0);

            switch (choice) {
                case '1':
                    lista.inicializarLista();
                    break;
                case '2':
                    lista.apresentarProximo();
                    break;
                case '3':
                    lista.apresentarAnterior();
                    break;
                case '4':
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
                    int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno:"));
                    lista.inserir(nome, ra);
                    break;
                case '5':
                    lista.eliminarUltimo();
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

class Aluno {
    String nome;
    long ra;
    Aluno anterior;
    Aluno proximo;

    Aluno(String nome, long ra) {
        this.nome = nome;
        this.ra = ra;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    Aluno primeiro;
    Aluno ultimo;
    Aluno atual;

    ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.atual = null;
    }

    void inicializarLista() {
        atual = primeiro;
        JOptionPane.showMessageDialog(null, "Lista Inicializada");
    }

    void apresentarProximo() {
        if (primeiro == null) {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
            return;
        }
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Lista Encerrada");
            return;
        }
        JOptionPane.showMessageDialog(null, "Nome: " + atual.nome + ", RA: " + atual.ra);
        if (atual == ultimo) {
            JOptionPane.showMessageDialog(null, "Último da Lista");
        } else {
            atual = atual.proximo;
        }
    }

    void apresentarAnterior() {
        if (primeiro == null) {
            JOptionPane.showMessageDialog(null, "Lista Vazia");
            return;
        }
        if (atual == null) {
            JOptionPane.showMessageDialog(null, "Lista Encerrada");
            return;
        }
        JOptionPane.showMessageDialog(null, "Nome: " + atual.nome + ", RA: " + atual.ra);
        if (atual == primeiro) {
            JOptionPane.showMessageDialog(null, "Primeiro da Lista");
        } else {
            atual = atual.anterior;
        }
    }

    void inserir(String nome, int ra) {
        Aluno novoAluno = new Aluno(nome, ra);
        if (primeiro == null) {
            primeiro = novoAluno;
            ultimo = novoAluno;
        } else {
            if (atual == null) {
                novoAluno.anterior = ultimo;
                ultimo.proximo = novoAluno;
                ultimo = novoAluno;
            } else {
                novoAluno.proximo = atual.proximo;
                novoAluno.anterior = atual;
                if (atual.proximo != null) {
                    atual.proximo.anterior = novoAluno;
                }
                atual.proximo = novoAluno;
            }
        }
        atual = novoAluno;
    }

    void eliminarUltimo() {
        if (ultimo == null || primeiro == null) {
            JOptionPane.showMessageDialog(null, "Não há nó a ser Eliminado");
            return;
        }
        if (ultimo == primeiro) {
            primeiro = null;
            ultimo = null;
        } else {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
        }
        atual = primeiro;
        JOptionPane.showMessageDialog(null, "Nó Eliminado");
    }
}
