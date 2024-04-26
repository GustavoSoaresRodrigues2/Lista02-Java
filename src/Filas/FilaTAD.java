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

public class FilaTAD {
    private final int TAMANHO_MAXIMO;
    private No inicio;
    private No fim;
    private int tamanho;

    // Construtor que define o tamanho máximo da fila
    public FilaTAD() {
        this.TAMANHO_MAXIMO = 10;
        this.inicio = null;
        this.fim = null;
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
        if (isEmpty()) {
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }

    // Remove e retorna o elemento da frente da fila
    public void deQueue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia");
            return;
        }
        inicio = inicio.proximo;
        tamanho--;
        if (isEmpty()) {
            fim = null;
        }
    }

    // Retorna o elemento da frente da fila sem removê-lo
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return inicio.valor;
    }
}

