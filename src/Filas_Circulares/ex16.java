/*
    16) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de Dados).
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex16 {
    public static void main(String[] args) {

        FilaINT_CircularTAD FilaINT_CircularTAD = new FilaINT_CircularTAD();

        String input;

        do {
            input = JOptionPane.showInputDialog(
                "( A ) - Inserir Elemento\n" +
                "( B ) - Consultar Elemento\n" +
                "( C ) - Retirar Elemento\n" +
                "( D ) - Sair"
            );

            switch (input) {
                case "A":
                    int inserir = Integer.parseInt(
                        JOptionPane.showInputDialog(
                            "Digite o número que queira inserir."
                        )
                    );

                    FilaINT_CircularTAD.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + FilaINT_CircularTAD.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINT_CircularTAD.deQueueC();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
