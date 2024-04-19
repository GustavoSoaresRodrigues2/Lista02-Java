package Filas;

import javax.swing.JOptionPane;

public class Fila {
    private int[] iFila;
    private int iSPos; // Ponteiro de inserção
    private int iRPos; // Ponteiro de remoção
    private int iTamanho; // Tamanho máximo da fila

    public Fila() {
        iTamanho = 5;
        iFila = new int[iTamanho];
        iSPos = 0;
        iRPos = 0;
    }
    
    // Voce pode decidir o tamanho do vetor
    // public Fila(int tamanho) {
    //     iTamanho = tamanho;
    //     iFila = new int[iTamanho];
    //     iSPos = 0;
    //     iRPos = 0;
    // }

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