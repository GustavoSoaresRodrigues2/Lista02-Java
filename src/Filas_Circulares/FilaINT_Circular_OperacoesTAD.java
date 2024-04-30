package Filas_Circulares;

class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class FilaINT_Circular_OperacoesTAD {
    public int iTAM = 10;
    public No iFila[] = new No[iTAM];
    public int iSPos = 0;
    public int iRPos = 0;
    public boolean bQueueFull = false;

    public int size() {
        if (iSPos >= iRPos && !bQueueFull)
            return iSPos - iRPos;
        else
            return iSPos + iTAM - iRPos;
    }

    public int front() {
        return iFila[iRPos].valor;
    }

    public boolean isOver() {
        if (iSPos == iRPos && bQueueFull)
            return true;
        return false;
    }

    public void enQueueC(int iC) {
        No novoEle = new No(iC);
        iFila[iSPos++] = novoEle;
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

    public int soma() {
        int result = 0;
        for (int i = iRPos; i != iSPos; i = (i + 1) % iTAM) {
            result += iFila[i].valor;
        }
        return result;
    }

    public int subtracao() {
        int result = soma();
        if (iSPos != iRPos) {
            result -= iFila[iRPos].valor;
        }
        return result;
    }

    public int multiplicacao() {
        int result = 1;
        for (int i = iRPos; i != iSPos; i = (i + 1) % iTAM) {
            result *= iFila[i].valor;
        }
        return result;
    }

    public double divisao() {
        double result = multiplicacao();
        if (iSPos != iRPos) {
            int divisor = iFila[iRPos].valor;
            if (divisor != 0) {
                result /= divisor;
            } else {
                return 0;
            }
        }
        return result;
    }
}
