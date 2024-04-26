/*
    14) Elaborar um programa, em linguagem Java, capaz de armazenar no máximo 10
    nomes em um vetor, manipulando-os através de fila (implementação através de TADs).
    As operações básicas deverão obedecer ao seguinte menu:

    • Inserir Nome;
    • Consultar Nome;
    • Retirar Nome;
    • Sair.

    Optando por Inserir Nome, o programa deverá pedir ao operador que digite o nome a ser
    inserido na fila; optando por Consultar Nome, o programa deverá apresentar em tela o
    primeiro nome inserido na fila, sem que o mesmo seja retirado dela e a quantidade de
    nomes armazenados na fila; optando por Retirar Nome, o programa deverá retirar o
    primeiro nome da fila, apresentando-o em tela; E, optando por Sair, o programa deverá
    ser encerrado.
*/
package Filas;

import javax.swing.JOptionPane;

public class ex14 {

    public static void main(String[] args) {

        FilaSTRING FilaSTRING = new FilaSTRING();

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
                    String inserir = JOptionPane.showInputDialog("Digite o número que queira inserir.");

                    FilaSTRING.enQueue(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + FilaSTRING.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaSTRING.deQueue();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
