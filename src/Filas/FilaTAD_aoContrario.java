package Filas;

import javax.swing.JOptionPane;

class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class FilaTAD_aoContrario {
    private final int TAMANHO_MAXIMO;
    private No[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    // Construtor que define o tamanho máximo da fila
    public FilaTAD_aoContrario() {
        this.TAMANHO_MAXIMO = 10;
        this.elementos = new No[TAMANHO_MAXIMO];
        this.inicio = TAMANHO_MAXIMO - 1; // Começa no índice 9
        this.fim = TAMANHO_MAXIMO - 1; // Começa no índice 9
        this.tamanho = 0;
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
        No novoNo = new No(elemento);
        elementos[fim] = novoNo;
        fim = (fim - 1 + TAMANHO_MAXIMO) % TAMANHO_MAXIMO; // Avança o índice de fim circularmente
        tamanho++;
    }

    // Remove e retorna o elemento da frente da fila
    public void deQueue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia");
            return;
        }
        inicio = (inicio - 1 + TAMANHO_MAXIMO) % TAMANHO_MAXIMO; // Avança o índice de início circularmente
        tamanho--;
    }

    // Retorna o elemento da frente da fila sem removê-lo
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        int index = (inicio + 1) % TAMANHO_MAXIMO;
        return elementos[index].valor;
    }
}
