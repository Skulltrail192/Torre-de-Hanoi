package Interface;

import Negocios.Torres;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

public class Botoes {

    private int altura;
    private int lateral;
    private int largura;
    private ArrayList<JButton> botoes = new ArrayList();
    Torres torres = new Torres();

    public int incrementaPosicao(int j) {
        int minSide=0;
        switch (j) {
            case 1:
                minSide = 50;
                break;
            case 2:
                minSide = 330;
                break;
            case 3:
                minSide = 600;
                break;
        }
        return minSide;
    }

    public JButton addBotao(int i) {
        JButton bt = new JButton();
        largura = 150 - (i * 5);
        altura = 500 - ((i + 1) * 25);
        lateral = 50 + (i * 3);
        bt.setSize(largura, 25);
        bt.setLocation(lateral, altura);
        getBotoes().add(bt);
        torres.getPilha(1).push(i);
        if (i % 2 == 0) {
            bt.setBackground(Color.blue);
        } else {
            bt.setBackground(Color.gray);
        }
        return bt;
    }

    public void removeBotao() {
        for (int i = 0; i < getBotoes().size(); i++) {
            getBotoes().get(i).remove(i);
        }
    }

    public ArrayList<JButton> getBotoes() {
        return botoes;
    }

    public void setPosicao(int i, int j) {
        int temporario;
        temporario = (Integer) torres.getPilha(i).pop();
        torres.getPilha(j).push(temporario);
        lateral = incrementaPosicao(j) + (temporario * 3);
        altura = 500 - (torres.getPilha(j).size() * 25);
        getBotoes().get(temporario).setLocation(lateral, altura);
    }

    public void reset(int size) {
        getBotoes().clear();
        torres.getPilha(1).clear();
        torres.getPilha(2).clear();
        torres.getPilha(3).clear();
     }
}