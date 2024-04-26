package Filas;

import javax.swing.JOptionPane;

public class FilaINT_aoContrario {
    private int[] iFila;
    private int iSPos; // Ponteiro de inserção
    private int iRPos; // Ponteiro de remoção
    private int iTamanho; // Tamanho máximo da fila

    public FilaINT_aoContrario() {
        iTamanho = 15; // Tamanho máximo da fila + 1 (para comportar 15 elementos)
        iFila = new int[iTamanho];
        iSPos = 9; // Começa a fila no índice 9
        iRPos = 9; // Começa a fila no índice 9
    }
    
    public int size() {
        return (iSPos - iRPos + iTamanho) % iTamanho;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return iFila[iRPos];
    }

    public boolean isEmpty() {
        return iSPos == iRPos;
    }

    public boolean isFull() {
        return size() == iTamanho - 1;
    }

    public void enQueue(int elemento) {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia");
        } else {
            iFila[iSPos] = elemento;
            iSPos = (iSPos + 1) % iTamanho;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia");
            return 0;
        } else {
            int elemento = iFila[iRPos];
            iRPos = (iRPos + 1) % iTamanho;
            return elemento;
        }
    }
}