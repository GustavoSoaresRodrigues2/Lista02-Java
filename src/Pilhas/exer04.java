package Pilhas;

import java.util.EmptyStackException;

// Definição da classe abstrata Pilha
abstract class Pilha {
    protected int tamanhoMaximo;

    public Pilha(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public abstract void inserirElemento(char elemento);

    public abstract char consultarElemento();

    public abstract char retirarElemento();

    public abstract boolean estaVazia();

    public abstract boolean estaCheia();
}

// Implementação da classe PilhaCaracteres que herda da classe abstrata Pilha
class PilhaCaracteres extends Pilha {
    private char[] elementos;
    private int topo;

    public PilhaCaracteres(int tamanhoMaximo) {
        super(tamanhoMaximo);
        this.elementos = new char[tamanhoMaximo];
        this.topo = -1;
    }

    @Override
    public void inserirElemento(char elemento) {
        if (!estaCheia()) {
            topo++;
            elementos[topo] = elemento;
            System.out.println("Elemento inserido com sucesso.");
        } else {
            System.out.println("A pilha está cheia. Não é possível inserir mais elementos.");
        }
    }

    @Override
    public char consultarElemento() {
        if (!estaVazia()) {
            return elementos[topo];
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public char retirarElemento() {
        if (!estaVazia()) {
            char elementoRetirado = elementos[topo];
            topo--;
            return elementoRetirado;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public boolean estaCheia() {
        return topo == tamanhoMaximo - 1;
    }
    
    public static void main(String[] args) {
        Pilha pilha = new PilhaCaracteres(10);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Elemento");
            System.out.println("2. Consultar Elemento");
            System.out.println("3. Retirar Elemento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido na pilha: ");
                    char elemento = scanner.next().charAt(0);
                    pilha.inserirElemento(elemento);
                    break;
                case 2:
                    try {
                        System.out.println("Último elemento inserido na pilha: " + pilha.consultarElemento());
                    } catch (EmptyStackException e) {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento retirado: " + pilha.retirarElemento());
                    } catch (EmptyStackException e) {
                        System.out.println("A pilha está vazia. Não há elementos para retirar.");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
