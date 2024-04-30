/*
    19) Utilizando o mesmo princípio das funções do exercício anterior, elaborar um
    programa que realize as 4 operações matemáticas entre 5 números do tipo int, que deverão
    ser digitados primeiramente em sua totalidade e armazenados em uma fila circular e só
    após isto, conforme as operações matemáticas que forem sendo digitadas, o resultado da
    conta venha sendo apresentado sempre em relação aos primeiros elementos da fila
    circular remanescente.

    Exemplo: Digitados Apresentado Observação
    6 <- 6
    2 <- 2
    3 <- 3
    4 <- 4
    5 <- 5
    + <- 8 <6+2>
    - <- 5 <8-3>
    * <- 20 <5*4>
    / <- 4 <20/5>
*/

package Filas_Circulares;

import javax.swing.JOptionPane;

public class ex19 {
    public static void main(String[] args) {

        FilaINT_Circular_Operacoes FilaINT_Circular_Operacoes = new FilaINT_Circular_Operacoes();

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

                    FilaINT_Circular_Operacoes.enQueueC(inserir);                    
                break;
                case "B":
                    JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                    FilaINT_Circular_Operacoes.deQueueC();
                break;
                case "C":
                    JOptionPane.showMessageDialog(null, "Somando os elementos: " + FilaINT_Circular_Operacoes.soma());
                break;
                case "D":
                    JOptionPane.showMessageDialog(null, "Subtraindo os elementos: " + FilaINT_Circular_Operacoes.subtracao());
                break;
                case "E":
                    JOptionPane.showMessageDialog(null, "Multiplicando os elementos: " + FilaINT_Circular_Operacoes.multiplicacao());
                break;
                case "F":
                    JOptionPane.showMessageDialog(null, "Dividindo os elementos: " + FilaINT_Circular_Operacoes.divisao());  
                break;
                default:
                break;
            }
        } while (!input.equals("G"));
    }
}
