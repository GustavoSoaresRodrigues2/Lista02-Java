/*
    18) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de
    Dados).
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex18 {
    public static void main(String[] args) {

        FilaINT_CircularTAD_aoContrario FilaINT_CircularTAD_aoContrario = new FilaINT_CircularTAD_aoContrario();

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

                    FilaINT_CircularTAD_aoContrario.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + FilaINT_CircularTAD_aoContrario.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINT_CircularTAD_aoContrario.deQueueC();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
