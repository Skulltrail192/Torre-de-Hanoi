package Interface;

import Negocios.Temporizador;
import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TelaPrincipal extends JFrame {

    JButton iniciar;
    JButton reiniciar;
    JSpinner discos;
    JLabel texto;
    JLabel numeroDePassos;
    JLabel numeroDePassosTexto;
    JLabel fundo;
    Botoes botoes = new Botoes();
    private int size = 1;
    private int vez = 0;
    private int contagem = 0;
    Temporizador temporizador = new Temporizador();

    public TelaPrincipal() {
        initComponents();
    }

    public void iniciarActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        if (vez == 0) {
            firstStart();
        } else {
            restart();
            botoes.reset(size);
            temporizador.resetarContagem();
            start();
        }
    }

    public void reiniciarActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        for (int i = 0; i < size; i++) {
            getContentPane().remove(botoes.getBotoes().get(i));
            repaint();
        }
        getContentPane().add(botoes.addBotao(0));
    }

    public void start() throws InterruptedException {
        size = Integer.parseInt(discos.getValue().toString());
        Temporizador.setFrame(this);
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                getContentPane().add(botoes.addBotao(i));
                repaint();
            }
            update(getGraphics());
            Temporizador.hanoi(size, 1, 3, 2, botoes, numeroDePassos);
        }
    }

    public void firstStart() throws InterruptedException {
        getContentPane().remove(botoes.getBotoes().get(0));
        botoes.reset(0);
        start();
        vez++;
    }

    public void restart() throws InterruptedException {
        contagem = 0;
        numeroDePassos.setText(String.valueOf(contagem));
        update(getGraphics());
        for (int i = 0; i < size; i++) {
            getContentPane().remove(botoes.getBotoes().get(i));
            repaint();
        }
    }

    private void lookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o tema = " + erro);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public static void main(String args[]) {
        new TelaPrincipal();
    }

    private void initComponents() {
        lookAndFeel();
        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        setSize(800, 600);
        SpinnerModel sm = new SpinnerNumberModel(1, 1, 64, 1);
        discos = new JSpinner(sm);
        discos.setLocation(100, 20);
        discos.setSize(50, 25);
        iniciar = new JButton("Iniciar");
        iniciar.setLocation(180, 20);
        iniciar.setSize(80, 25);
        reiniciar = new JButton("Reiniciar");
        reiniciar.setLocation(260, 20);
        reiniciar.setSize(80, 25);
        texto = new JLabel("Discos");
        texto.setLocation(40, 10);
        texto.setSize(50, 40);
        numeroDePassos = new JLabel();
        numeroDePassos.setText("0");
        numeroDePassos.setSize(50, 40);
        numeroDePassos.setLocation(700, 520);
        numeroDePassosTexto = new JLabel("passos");
        numeroDePassosTexto.setSize(50, 30);
        numeroDePassosTexto.setLocation(720, 524);
        getContentPane().setLayout(null);
        getContentPane().add(iniciar);
        getContentPane().add(reiniciar);
        getContentPane().add(discos);
        getContentPane().add(texto);
        getContentPane().add(numeroDePassos);
        getContentPane().add(numeroDePassosTexto);
        getContentPane().add(botoes.addBotao(0));
        setVisible(true);
        iniciar.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    iniciarActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        reiniciar.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    reiniciarActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Torre de Hanoi");
    }
}