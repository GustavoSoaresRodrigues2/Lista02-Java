package Filas_Circulares;

public class FilaSTRING_Circular {
    public int iTAM = 10;
    public String iFila [ ] = new String [ iTAM ];
    public int iSPos = 0;
    public int iRPos = 0;
    public boolean bQueueFull = false;

    public int size ( )
    {
    if ( iSPos >= iRPos && ! bQueueFull ) return iSPos - iRPos;
    else return iSPos + iFila.length - iRPos;
    }

    public String front ( )
    {
    return iFila [ iRPos ];
    }

    public boolean isOver ( )
    {
    if ( iSPos == iRPos && bQueueFull ) return true;
    return false;
    }

    public void enQueueC ( String iC )
    {
    iFila [ iSPos++ ] = iC;
    if ( iSPos >= iFila.length ) iSPos=0;
    if( iSPos == iRPos) bQueueFull = true;
    }

    public String deQueueC ( )
    {
    int iIndice = iRPos++;
    if ( iRPos >= iFila.length ) iRPos = 0;
    bQueueFull = false;
    return iFila [ iIndice ];
    }  
}
