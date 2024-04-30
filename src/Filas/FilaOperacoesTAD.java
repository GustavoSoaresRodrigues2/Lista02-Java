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

public class FilaOperacoesTAD {
    private final int TAMANHO_MAXIMO;
    private No[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    // Construtor que define o tamanho máximo da fila
    public FilaOperacoesTAD() {
        TAMANHO_MAXIMO = 5;
        elementos = new No[TAMANHO_MAXIMO];
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
    public void enQueue(No elemento) {
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
    public No front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elementos[inicio];
    }

    public int soma() {
        if (isFull()) {

            No primeiro = front();
            No segundo = elementos[(inicio + 1) % TAMANHO_MAXIMO];
            return primeiro.valor + segundo.valor;
        } else {
            return 0;
        }
    }

    public int subtracao() {
        if (isFull()) {
            No primeiro = elementos[inicio];
            No segundo = elementos[(inicio + 1) % TAMANHO_MAXIMO];
            No terceiro = elementos[(inicio + 2) % TAMANHO_MAXIMO];
            return (primeiro.valor + segundo.valor) - terceiro.valor;
        } else {
            return 0;
        }
    }

    public int multiplicacao() {
        if (isFull()) {
            No primeiro = elementos[inicio];
            No segundo = elementos[(inicio + 1) % TAMANHO_MAXIMO];
            No terceiro = elementos[(inicio + 2) % TAMANHO_MAXIMO];
            No quarto = elementos[(inicio + 3) % TAMANHO_MAXIMO];
            return ((primeiro.valor + segundo.valor) - terceiro.valor) * quarto.valor;
        } else {
            return 0;
        }
    }

    public int divisao() {
        if (isFull()) {
            No primeiro = elementos[inicio];
            No segundo = elementos[(inicio + 1) % TAMANHO_MAXIMO];
            No terceiro = elementos[(inicio + 2) % TAMANHO_MAXIMO];
            No quarto = elementos[(inicio + 3) % TAMANHO_MAXIMO];
            No quinto = elementos[(inicio + 4) % TAMANHO_MAXIMO];
            return (((primeiro.valor + segundo.valor) - terceiro.valor) * quarto.valor) / quinto.valor;
        } else {
            return 0;
        }
    }
}
