/*
    17) Idem ao exercício 15, porém levando-se em conta que o elemento de índice 9 deverá
    ser o primeiro armazenado e o elemento de índice 0 deverá ser o último armazenado na
    fila circular, e assim seguindo sucessivamente.
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex17 {
    
    public static void main(String[] args) {

        FilaINT_Circular_aoContrario FilaINT_Circular_aoContrario = new FilaINT_Circular_aoContrario();

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

                    FilaINT_Circular_aoContrario.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + FilaINT_Circular_aoContrario.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINT_Circular_aoContrario.deQueueC();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
