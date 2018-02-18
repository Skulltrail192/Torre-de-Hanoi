package Negocios;

import java.util.Stack;

public class Torres {

    private Stack<Integer> pilha1 = new Stack();
    private Stack<Integer> pilha2 = new Stack();
    private Stack<Integer> pilha3 = new Stack();
    private Stack<Integer> pilha = new Stack();

    public Torres() {
    } 

    public Stack getPilha(int i) {
        if (i == 1) {
            pilha = pilha1;
        }
        if (i == 2) {
            pilha = pilha2;
        }
        if (i == 3) {
            pilha = pilha3;
        }
        return pilha;
    }
}
