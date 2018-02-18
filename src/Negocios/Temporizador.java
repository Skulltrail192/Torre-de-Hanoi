package Negocios;

import Interface.Botoes;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Temporizador extends Thread{
      public static int contagem;
      private static JFrame frame = new JFrame();
      public static void hanoi(int n, int O, int D, int T, Botoes botoes, JLabel passos) throws InterruptedException {
        if (n > 0) {
            hanoi(n - 1, O, T, D, botoes, passos);
            botoes.setPosicao(O, D);
            sleep(500);
            contagem++;            
            getFrame().update(getFrame().getGraphics());
            passos.setText(String.valueOf(contagem));
            hanoi(n - 1, T, D, O, botoes, passos);
        }
    }

    public static void resetarContagem(){
        contagem=0;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame Frame) {
        frame = Frame;
    }
}
