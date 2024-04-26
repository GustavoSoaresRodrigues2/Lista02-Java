/*
    8) Elaborar um programa, em linguagem Java, capaz de armazenar no máximo 10
    caracteres em um vetor, manipulando-os através da estrutura de dados denominada fila
    (implementação conceitual). O elemento de índice 0 desse vetor deverá ser o primeiro a
    ser armazenado e por consequência o primeiro a ser retirado. As operações básicas dessa
    estrutura de dados deverão obedecer ao seguinte menu:

        • Inserir Elemento;
        • Consultar Elemento;
        • Retirar Elemento;
        • Sair.

    Optando por Inserir Elemento, o programa deverá pedir ao operador que digite o elemento
    a ser inserido na fila; optando por Consultar Elemento, o programa deverá apresentar em
    tela o primeiro elemento inserido na fila, sem que o mesmo seja retirado dela e a
    quantidade de elementos armazenados na fila; optando por Retirar Elemento, o programa
    deverá retirar o primeiro elemento da fila, apresentando-o em tela; E, optando por Sair, o
    programa deverá ser encerrado.
*/

package Filas;

import javax.swing.JOptionPane;

public class ex08 {
    
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
