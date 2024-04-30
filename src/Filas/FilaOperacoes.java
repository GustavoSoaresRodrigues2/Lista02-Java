package Filas;

import javax.swing.JOptionPane;

public class FilaOperacoes {
    private final int TAMANHO_MAXIMO;
    private int[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    // Construtor que define o tamanho máximo da fila
    public FilaOperacoes() {
        TAMANHO_MAXIMO = 5;
        elementos = new int[TAMANHO_MAXIMO];
        inicio = 0;
        fim = -1; // Inicia como -1 para indicar que a fila está vazia
        tamanho = 0;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Verifica se a fila está cheia
    public boolean isFull() {
        return tamanho == TAMANHO_MAXIMO;
    }

    // Retorna o tamanho atual da fila
    public int size() {
        return tamanho;
    }

    // Adiciona um elemento à fila
    public void enQueue(int elemento) {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia. Não é possível adicionar mais elementos.");
            return;
        }
        fim = (fim + 1) % TAMANHO_MAXIMO; // Avança o índice de fim circularmente
        elementos[fim] = elemento;
        tamanho++;
    }

    // Remove e retorna o elemento da frente da fila
    public void deQueue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia");
        }
        inicio = (inicio + 1) % TAMANHO_MAXIMO; // Avança o índice de início circularmente
        tamanho--;
    }

    // Retorna o elemento da frente da fila sem removê-lo
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elementos[inicio];
    }

    public int soma;
    public int subtracao;
    public int multiplicacao;
    public int divisao;

    public int soma() {
        if (isFull()) {
            int v1 = elementos[0];
            int v2 = elementos[1];

            return v1 + v2;
        } else {
            return 0;
        }
    }

    public int subtracao() {
        if (isFull()) {
            int v1 = soma();
            int v2 = elementos[2];

            return v1 - v2;
        } else {
            return 0;
        }
    }

    public int multiplicacao() {
        if (isFull()) {
            int v1 = subtracao();
            int v2 = elementos[3];

            return v1 * v2;
        } else {
            return 0;
        }
    }

    public int divisao() {
        if (isFull()) {
            int v1 = multiplicacao();
            int v2 = elementos[4];

            return v1 / v2;
        } else {
            return 0;
        }
    }
}
