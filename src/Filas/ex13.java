/*
    13) Idem ao anterior, porém implementando-o através de TADs (Tipos Abstratos de Dados).
*/
package Filas;

import javax.swing.JOptionPane;

public class ex13 {
    public static void main(String[] args) {

        FilaOperacoes Fila = new FilaOperacoes();

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

                    Fila.enQueue(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    Fila.deQueue();
                break;
                case "C":
                    if (Fila.soma() != 0) {
                        JOptionPane.showMessageDialog(null, "Somando os elementos: " + Fila.soma());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia");
                    }
                break;
                case "D":
                    if (Fila.subtracao() != 0) {
                        JOptionPane.showMessageDialog(null, "Subtraindo os elementos: " + Fila.subtracao());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia");
                    }
                break;
                case "E":
                    if (Fila.multiplicacao() != 0) {
                        JOptionPane.showMessageDialog(null, "Multiplicando os elementos: " + Fila.multiplicacao());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia");
                    }
                break;
                case "F":
                    if (Fila.divisao() != 0) {
                        JOptionPane.showMessageDialog(null, "Dividindo os elementos: " + Fila.divisao());
                    } else {
                        JOptionPane.showMessageDialog(null, "A fila está vazia");
                    }
                break;
                default:
                break;
            }
        } while (!input.equals("G"));
    }
}
