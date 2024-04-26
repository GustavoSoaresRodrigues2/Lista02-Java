/*
    9) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de
    Dados).
*/
package Filas;

import javax.swing.JOptionPane;

public class ex09 {

    public static void main(String[] args) {

        FilaTAD Fila = new FilaTAD();

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
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + Fila.front());
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
