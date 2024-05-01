package Pilhas;

import java.util.Scanner;

class Stack {
    private String[] stack;
    private int top;
    private static final int MAX_SIZE = 10;

    public Stack() {
        stack = new String[MAX_SIZE];
        top = -1;
    }

    public void push(String name) {
        if (top < MAX_SIZE - 1) {
            stack[++top] = name;
            System.out.println("Nome inserido na pilha.");
        } else {
            System.out.println("A pilha está cheia. Não é possível adicionar mais nomes.");
        }
    }

    public String pop() {
        if (top >= 0) {
            return stack[top--];
        } else {
            System.out.println("A pilha está vazia. Não é possível retirar nomes.");
            return null;
        }
    }

    public String peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("A pilha está vazia.");
            return null;
        }
    }

    public int size() {
        return top + 1;
    }
}

public class exer07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Nome");
            System.out.println("2. Consultar Nome");
            System.out.println("3. Retirar Nome");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome a ser inserido: ");
                    String name = scanner.nextLine();
                    stack.push(name);
                    break;
                case 2:
                    String lastName = stack.peek();
                    if (lastName != null) {
                        System.out.println("Último nome inserido: " + lastName);
                        System.out.println("Quantidade de nomes armazenados na pilha: " + stack.size());
                    }
                    break;
                case 3:
                    String removedName = stack.pop();
                    if (removedName != null) {
                        System.out.println("Nome retirado: " + removedName);
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
