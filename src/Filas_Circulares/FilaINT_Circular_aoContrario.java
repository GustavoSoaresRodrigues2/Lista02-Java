package Filas_Circulares;

public class FilaINT_Circular_aoContrario {
    public int iTAM = 10;
    public int[] iFila = new int[iTAM];
    public int iSPos = 9; // Começa no índice 9
    public int iRPos = 9; // Começa no índice 9
    public boolean bQueueFull = false;

    public int size() {
        if (iSPos >= iRPos && !bQueueFull)
            return iSPos - iRPos;
        else
            return iSPos + iTAM - iRPos;
    }

    public int front() {
        return iFila[iRPos];
    }

    public boolean isOver() {
        if (iSPos == iRPos && bQueueFull)
            return true;
        return false;
    }

    public void enQueueC(int iC) {
        iFila[iSPos--] = iC; // Decrementa iSPos
        if (iSPos < 0)
            iSPos = iTAM - 1; // Volta para o último índice se necessário
        if (iSPos == iRPos)
            bQueueFull = true;
    }

    public int deQueueC() {
        int iIndice = iRPos--;
        if (iRPos < 0)
            iRPos = iTAM - 1; // Volta para o último índice se necessário
        bQueueFull = false;
        return iFila[iIndice];
    }
}
