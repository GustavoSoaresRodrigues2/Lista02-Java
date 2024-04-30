/*
    15) Elaborar um programa, em linguagem Java, capaz de armazenar no máximo 10
    caracteres em um vetor, manipulando-os através da estrutura de dados denominada fila
    circular (implementação conceitual). O elemento de índice 0 desse vetor deverá ser o
    primeiro a ser armazenado e por consequência o primeiro a ser retirado. As operações
    básicas dessa estrutura de dados deverão obedecer ao seguinte menu:

    • Inserir Elemento;
    • Consultar Elemento;
    • Retirar Elemento;
    • Sair.

    Optando por Inserir Elemento, o programa deverá pedir ao operador que digite o elemento
    a ser inserido na fila circular; Optando por Consultar Elemento, o programa deverá
    apresentar em tela o primeiro elemento inserido na fila circular, sem que o mesmo seja
    retirado dela e a quantidade de elementos armazenados na fila circular; Optando por
    Retirar Elemento, o programa deverá retirar o primeiro elemento da fila circular,
    apresentando-o em tela; E, optando por Sair, o programa deverá ser encerrado.
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex15 {
    
    public static void main(String[] args) {

        FilaINT_Circular FilaINTCircular = new FilaINT_Circular();

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

                    FilaINTCircular.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Primeiro elemento: " + FilaINTCircular.front());
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINTCircular.deQueueC();
                break;
            
                default:
                    break;
            }
        } while (!input.equals("D"));
    }
}
