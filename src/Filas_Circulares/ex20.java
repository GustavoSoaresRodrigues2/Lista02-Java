/*
    20) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de
    Dados).
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex20 {
    public static void main(String[] args) {

        FilaINT_Circular_OperacoesTAD FilaINT_Circular_OperacoesTAD = new FilaINT_Circular_OperacoesTAD();

        String input;

        do {
            input = JOptionPane.showInputDialog(
                "( A ) - Inserir Elemento\n" +
                "( B ) - Retirar Elemento\n" +
                "( C ) - Somar Elementos\n" +
                "( D ) - Subtrair Elementos\n" +
                "( E ) - Multiplicar Elementos\n" +
                "( F ) - Dividir Elementos\n" +
                "( G ) - Sair"
            );

            switch (input) {
                case "A":
                    int inserir = Integer.parseInt(
                        JOptionPane.showInputDialog(
                            "Digite o número que queira inserir."
                        )
                    );

                    FilaINT_Circular_OperacoesTAD.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINT_Circular_OperacoesTAD.deQueueC();
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Somando os elementos: " + FilaINT_Circular_OperacoesTAD.soma());
                break;
                case "D":
                    JOptionPane.showMessageDialog(null, "Subtraindo os elementos: " + FilaINT_Circular_OperacoesTAD.subtracao());
                break;
                case "E":
                    JOptionPane.showMessageDialog(null, "Multiplicando os elementos: " + FilaINT_Circular_OperacoesTAD.multiplicacao());
                break;
                case "F":
                    JOptionPane.showMessageDialog(null, "Dividindo os elementos: " + FilaINT_Circular_OperacoesTAD.divisao());  
                break;
                default:
                break;
            }
        } while (!input.equals("G"));
    }
}
