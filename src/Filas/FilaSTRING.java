package Filas;

import javax.swing.JOptionPane;

public class FilaSTRING {
    private final int TAMANHO_MAXIMO;
    private String[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    // Construtor que define o tamanho máximo da fila
    public FilaSTRING() {
        TAMANHO_MAXIMO = 10;
        elementos = new String[TAMANHO_MAXIMO];
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
    public void enQueue(String elemento) {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia. Não é possível adicionar mais elementos.");
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
    public String front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elementos[inicio];
    }
}
