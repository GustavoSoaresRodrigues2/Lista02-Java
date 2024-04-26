/*
    11) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de
    Dados)
*/
package Filas;

import javax.swing.JOptionPane;

public class ex11 {
    
    public static void main(String[] args) {

        FilaTAD_aoContrario Fila = new FilaTAD_aoContrario();

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

                    Fila.enQueue(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Ultimo elemento: " + Fila.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    Fila.deQueue();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
