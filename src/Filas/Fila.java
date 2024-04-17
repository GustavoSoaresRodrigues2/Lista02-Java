package Filas;

public class Fila {
    public static int iTAM = 10;
    public static int iFila[] = new int[iTAM];
    public static int iSPos = 0;
    public static int iRPos = 10;
    public static boolean bQueueFull = false;
    
    public static int size() 
    {
        if (iSPos >= iRPos && !bQueueFull) return iSPos - iRPos;
        else return iSPos + iFila.length - iRPos;
    }

    public static int front()
    {
        return iFila[iRPos];
    }

    public static boolean isOver ( )
    {
        if ( iSPos == iRPos && bQueueFull ) return true;
        return false;
    }
    
    public static void enQueueC ( int iC )
    {
        iFila [ iSPos++ ] = iC;
        if ( iSPos >= iFila.length ) iSPos=0;
        if( iSPos == iRPos) bQueueFull = true;
    }

    public static int deQueueC ( )
    {
        int iIndice = iRPos++;
        if ( iRPos >= iFila.length ) iRPos = 0;
        bQueueFull = false;
        return iFila [ iIndice ];
    }

    
}
