/*
    10) Idem ao exercício 8, porém levando-se em conta que o elemento de índice 9 deverá
    ser o primeiro armazenado e o elemento de índice 0 deverá ser o último armazenado na
    fila
*/
package Filas;

import javax.swing.JOptionPane;

public class ex10 {
    public static void main(String[] args) {

        FilaINT Fila = new FilaINT();

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
