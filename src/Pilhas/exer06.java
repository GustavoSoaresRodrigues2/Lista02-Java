package Pilhas;

import java.util.Scanner;

public class exer06 {
private static final int TAMANHO_MAXIMO = 5;
private static int[] vetor = new int[TAMANHO_MAXIMO];
private static int topo = 0; // Índice do topo da Pilha

// Insere um elemento na 
public static void inserirElemento(int elemento) {
    if (topo < TAMANHO_MAXIMO ) {
        vetor[topo] = elemento;
        topo++;
        System.out.println("Elemento '" + elemento + "' inserido na .");
    } else {
        System.out.println("A  está cheia, não é possível inserir mais elementos.");
    }
}

// Consulta o último elemento da 
public static void consultarElemento() {
    if (topo >= 0) {
        System.out.println("Último elemento inserido na : " + vetor[topo]);
        System.out.println("Quantidade de elementos na : " + (topo + 1));
    } else {
        System.out.println("A  está vazia.");
    }
}

// Remove o último elemento da 
public static void retirarElemento() {
    if (topo >= 0) {
        int elemento = vetor[topo];
        topo--;
        System.out.println("Elemento '" + elemento + "' retirado da .");
    } else {
        System.out.println("A  está vazia.");
    }
}

// Realiza a soma dos dois últimos elementos na 
public static int soma() {
    if (topo >= 1) {
        int valor1 = vetor[topo];
        int valor2 = vetor[1];
        int resultado = valor1 + valor2;
        vetor[topo - 1] = resultado;
        topo--;
        return resultado;
    } else {
        System.out.println("Não há elementos suficientes na  para realizar a operação.");
        return 0;
    }
}

// Realiza a subtração entre os dois últimos elementos da 
public static int subtracao() {
    if (topo >= 1) {
        int valor1 = soma();
        int valor2 = vetor[2];
        int resultado = valor2 - valor1;
        vetor[topo - 1] = resultado;
        topo--;
        return resultado;
    } else {
        System.out.println("Não há elementos suficientes na  para realizar a operação.");
        return 0;
    }
}

// Realiza a multiplicação entre os dois últimos elementos da 
public static int multiplicacao() {
    if (topo >= 1) {
        int valor1 = subtracao();
        int valor2 = vetor[3];
        int resultado = valor1 * valor2;
        vetor[topo - 1] = resultado;
        topo--;
        return resultado;
    } else {
        System.out.println("Não há elementos suficientes na  para realizar a operação.");
        return 0;
    }
}

// Realiza a divisão entre os dois últimos elementos da 
public static int divisao() {
    if (topo >= 1) {
        int valor1 = multiplicacao();
        int valor2 = vetor[4];
        if (valor1 == 0) {
            System.out.println("Erro: divisão por zero.");
            return 0;
        }
        int resultado = valor2 / valor1;
        vetor[topo - 1] = resultado;
        topo--;
        return resultado;
    } else {
        System.out.println("Não há elementos suficientes na  para realizar a operação.");
        return 0;
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int opcao;

    do {
        System.out.println("\nMenu:");
        System.out.println("1. Inserir Elemento");
        System.out.println("2. Consultar Elemento");
        System.out.println("3. Retirar Elemento");
        System.out.println("4. Sair");
        System.out.println("5. Somar Elementos");
        System.out.println("6. Subtrair Elementos");
        System.out.println("7. Multiplicar Elementos");
        System.out.println("8. Dividir Elementos");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o elemento a ser inserido na Pilha: ");
                int elemento = scanner.nextInt();
                inserirElemento(elemento);
                break;
            case 2:
                consultarElemento();
                break;
            case 3:
                retirarElemento();
                break;
            case 4:
                System.out.println("Encerrando o programa...");
                break;
            case 5:
                System.out.println("Soma: " + soma());
                break;
            case 6:
                System.out.println("Subtração: " + subtracao());
                break;
            case 7:
                System.out.println("Multiplicação: " + multiplicacao());
                break;
            case 8:
                System.out.println("Divisão: " + divisao());
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    } while (opcao != 4);

    scanner.close();
}
}
