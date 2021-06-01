package com.company;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class ProblemasMatematicos extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private int respuestaUsuario;
    private int resultado;
    private String mensaje;

    public ProblemasMatematicos() {

        int a = (int) Math.floor(Math.random() * 79 + 1);
        int b = (int) Math.floor(Math.random() * 43 + 1);
        int c = a + b;
        int d = c + 2;
        int e = c - 1;


        setTitle("Perdiste");
        setBounds(230, 70, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //Etiquetas
        JLabel lblEscribeElNombre = new JLabel("Enviar respuesta la respuesta");
        lblEscribeElNombre.setBounds(125, 22, 229, 25);
        contentPane.add(lblEscribeElNombre);

        JLabel lblperdiste = new JLabel("Perdiste!!");
        lblperdiste.setBounds(40, 22, 109, 14);
        contentPane.add(lblperdiste);


        //ubicar la pregunta
        JLabel pregunta = new JLabel(a + "+" + b);
        pregunta.setBounds(125, 150, 141, 20);
        contentPane.add(pregunta);


        JLabel lblNombreElegido = new JLabel("La operacion es:");
        lblNombreElegido.setBounds(125, 124, 110, 14);
        contentPane.add(lblNombreElegido);

        textField = new JTextField();
        textField.setBounds(125, 68, 193, 26);
        contentPane.add(textField);


        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(225, 124, 89, 23);
        contentPane.add(btnEnviar);


        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultado = a + b;
                // comboBox.addItem(textField.getText());
                // textField.setText("");

                respuestaUsuario =  Integer.parseInt(textField.getText());

                if (respuestaUsuario == resultado) {

                    mensaje="Tu respuesta fue correcta!";
                    mensaje="Tu respuesta fue correcta!";

                } else {
                    mensaje="Tu respuesta fue incorrecta!";
                }
                JOptionPane.showMessageDialog(contentPane, mensaje);
                setVisible(false);
                dispose();
            }
        });
    }
}