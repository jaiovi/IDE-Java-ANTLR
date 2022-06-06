/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ide.java.antlr;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

/**
 *
 * @author NINJA
 */
public class Output extends JFrame {
    private static JTextArea textArea;
    private static JTextArea lines;
    private JScrollPane jsp;
    String output;
    
    public Output (String o) {
        output = o;
        setTitle("Output de ejecucion");
        jsp = new JScrollPane();
        textArea = new JTextArea(5, 20);
        textArea.setText(o);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        jsp.getViewport().add(textArea);
        add(jsp);
        setSize(400, 275);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
