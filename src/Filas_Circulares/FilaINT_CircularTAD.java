package Filas_Circulares;

class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class FilaINT_CircularTAD {
    public int iTAM = 10;
    public No iFila[] = new No[iTAM];
    public int iSPos = 0;
    public int iRPos = 0;
    public boolean bQueueFull = false;

    public int size() {
        if (iSPos >= iRPos && !bQueueFull)
            return iSPos - iRPos;
        else
            return iSPos + iFila.length - iRPos;
    }

    public int front() {
        return iFila[iRPos].valor;
    }

    public boolean isOver() {
        if (iSPos == iRPos && bQueueFull)
            return true;
        return false;
    }

    public void enQueueC(int inserir) {
        No novoNo = new No(inserir);
        iFila[iSPos++] = novoNo;
        if (iSPos >= iFila.length)
            iSPos = 0;
        if (iSPos == iRPos)
            bQueueFull = true;
    }

    public No deQueueC() {
        int iIndice = iRPos++;
        if (iRPos >= iFila.length)
            iRPos = 0;
        bQueueFull = false;
        return iFila[iIndice];
    }
}