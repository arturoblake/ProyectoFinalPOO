package com.company;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Juego {
    Idioma objIdioma = new Idioma("espaniol");
    Marcador marcador = new Marcador();

    public void bienvenida() {
        String info_text = objIdioma.getBienvenida();
        JOptionPane.showMessageDialog(null, info_text, objIdioma.getComoJugar(), 1);
    }

    public void jugar() {
        JFrame frame_main = new JFrame(objIdioma.getTitulo());
        frame_main.getContentPane().setBackground(Color.BLACK);
        Container panel_principal = frame_main.getContentPane();
        panel_principal.setLayout(null);

        String[] icon_path = new String[3];
        int[] icon_bound = new int[3];

        for (int i = 0; i <= 2; i++) {
            String filename = "C:\\Users\\artur\\IdeaProjects\\ProyectoPOO\\src\\com\\company" + "\\images\\" + i + ".png";
            icon_path[i] = filename;
            icon_bound[i] = 40 + 250 * i;
            System.out.println(filename);
            System.out.println(icon_path[i]);
        }

        JLabel titulo = new JLabel(objIdioma.getTitulo());
        titulo.setBounds(240, 20, 400, 40);
        titulo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);

        JButton btn_piedra = new JButton(" ", new ImageIcon(icon_path[0]));
        btn_piedra.setBackground(Color.green);
        btn_piedra.setBounds(icon_bound[0], 100, 200, 250);

        JButton btn_papel = new JButton(" ", new ImageIcon(icon_path[1]));
        btn_papel.setBackground(Color.cyan);
        btn_papel.setBounds(icon_bound[1], 100, 200, 250);

        JButton btn_tijera = new JButton(" ", new ImageIcon(icon_path[2]));
        btn_tijera.setBackground(Color.magenta);
        btn_tijera.setBounds(icon_bound[2], 100, 200, 250);

        JToggleButton toggle_button_tema = new JToggleButton(objIdioma.getModoLuz());
        ItemListener itemListenerTema = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                int state_tema = itemEvent.getStateChange();
                if (state_tema == ItemEvent.SELECTED) {
                    frame_main.getContentPane().setBackground(Color.WHITE);
                    titulo.setForeground(Color.BLACK);
                    toggle_button_tema.setText(objIdioma.getModoObscuro());
                } else {
                    frame_main.getContentPane().setBackground(Color.BLACK);
                    titulo.setForeground(Color.WHITE);
                    toggle_button_tema.setText(objIdioma.getModoLuz());
                    toggle_button_tema.setBackground(Color.white);
                }
            }
        };

        //
        JToggleButton toggle_button_idioma = new JToggleButton(objIdioma.getIdioma());
        ItemListener itemListenerIdioma = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                int state_idioma = itemEvent.getStateChange();
                if (state_idioma == ItemEvent.SELECTED) {
                    objIdioma.setIdioma("espaniol");
                    toggle_button_idioma.setText(objIdioma.getIdioma());
                } else {
                    objIdioma.setIdioma("ingles");
                    toggle_button_idioma.setText(objIdioma.getIdioma());
                }
            }
        };

        toggle_button_tema.addItemListener(itemListenerTema);
        toggle_button_tema.setBounds(570, 20, 150, 40);

        toggle_button_idioma.addItemListener(itemListenerIdioma);
        toggle_button_idioma.setBounds(570, 60, 150, 40);

        panel_principal.add(toggle_button_tema);
        panel_principal.add(toggle_button_idioma);
        panel_principal.add(btn_piedra);
        panel_principal.add(btn_tijera);
        panel_principal.add(btn_papel);
        panel_principal.add(titulo);

        btn_piedra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                calcular_ganador(1);
            }
        });

        btn_papel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                calcular_ganador(2);
            }
        });

        btn_tijera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                calcular_ganador(3);
            }
        });

        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.setSize(800, 400);
        frame_main.setVisible(true);
    }

    private void calcular_ganador(int eleccion_jugador) {
        int eleccion_computadora = (int)(Math.random() * 3) + 1;
        String label_choice, label_winner = "";
        String combo_winner = "" + Math.min(eleccion_computadora, eleccion_jugador) + Math.max(eleccion_computadora, eleccion_jugador);
        System.out.println("combo_winner:" + combo_winner);
        switch (Integer.parseInt(combo_winner)) {

            case 12:
                label_choice = objIdioma.getPapelGana();
                if (eleccion_jugador == 2)
                    marcador.setPuntuacion_jugador(1);
                break;
            case 13:
                label_choice = objIdioma.getPiedraGana();
                if (eleccion_jugador == 1)
                    marcador.setPuntuacion_jugador(1);
                break;
            case 23:
                label_choice = objIdioma.getTijeraGana();
                if (eleccion_jugador == 3)
                    marcador.setPuntuacion_jugador(1);
                break;
            default:
                label_choice = objIdioma.getEsEmpate();
                marcador.setPuntuacion_jugador(2);
                marcador.addPuntuacion_empate(1);
        }
        if (marcador.getPuntuacion_jugador() == 1) {
            label_winner = objIdioma.getJugadoGana();
            marcador.setPuntuacion_jugador(0);
            marcador.addPuntuacion_ganadora(1);
            marcador.addPuntuacion_total(1);
        } else if (marcador.getPuntuacion_jugador() == 2) {
            label_winner = objIdioma.getNadieGana();
            marcador.setPuntuacion_jugador(0);
        } else {
            label_winner = objIdioma.getMaquinaGana();
            marcador.addPuntuacion_total(1);

            ProblemasMatematicos pm = new ProblemasMatematicos();
        }

        JFrame score_frame = new JFrame(objIdioma.getTitulo());
        score_frame.getContentPane().setBackground(Color.WHITE);
        Container score_panel = score_frame.getContentPane();
        score_panel.setLayout(null);

        JLabel label_result = new JLabel(label_choice + label_winner);
        label_result.setBounds(150, 10, 300, 35);
        score_panel.add(label_result);

        JLabel label_title_human = new JLabel(objIdioma.getEleccionHumano());
        label_title_human.setBounds(50, 35, 150, 35);
        score_panel.add(label_title_human);

        JLabel label_title_computer = new JLabel(objIdioma.getEleccionMaquina());
        label_title_computer.setBounds(350, 35, 150, 35);
        score_panel.add(label_title_computer);

        JLabel image_human = new JLabel(
                new ImageIcon("C:\\Users\\artur\\IdeaProjects\\ProyectoPOO\\src\\com\\company" + "\\images\\" + (eleccion_jugador - 1) + ".png"));
        image_human.setBounds(10, 100, 200, 250);
        score_panel.add(image_human);

        JLabel image_computer = new JLabel(
                new ImageIcon("C:\\Users\\artur\\IdeaProjects\\ProyectoPOO\\src\\com\\company" + "\\images\\" + (eleccion_computadora - 1) + ".png"));
        image_computer.setBounds(300, 100, 200, 250);
        score_panel.add(image_computer);

        JLabel label_score1 = new JLabel(objIdioma.getTotal() + marcador.getPuntuacion_ganadora() + "/" + marcador.getPuntuacion_total());
        label_score1.setBounds(175, 200, 150, 350);
        score_panel.add(label_score1);

        JLabel label_score2 = new JLabel(objIdioma.getEmpate() + marcador.getPuntuacion_empate());
        label_score2.setBounds(175, 210, 125, 370);
        score_panel.add(label_score2);

        JButton btn_ok = new JButton("OK");
        btn_ok.setBackground(Color.green);
        btn_ok.setBounds(410, 360, 100, 50);
        score_panel.add(btn_ok);

        btn_ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                score_frame.dispose();
            }
        });

        score_frame.setSize(600, 450);
        score_frame.setVisible(true);
    }
}

