/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NumeritosNotepad;

/**
 * https://www.tutorialspoint.com/how-can-we-display-the-line-numbers-inside-a-jtextarea-in-java
 * @author sebjaiovi
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Element;


public class NumeritosNotepad extends JFrame {
   private static JTextArea textArea;
   private static JTextArea lines;
   private JScrollPane jsp;
   public NumeritosNotepad() {
      setTitle("LineNumberTextArea Test");
      jsp = new JScrollPane();
      textArea = new JTextArea();
      lines = new JTextArea("1");
      lines.setBackground(Color.LIGHT_GRAY);
      lines.setEditable(false);
      //  Code to implement line numbers inside the JTextArea
      textArea.getDocument().addDocumentListener(new DocumentListener() {
         public String getText() {
            int caretPosition = textArea.getDocument().getLength();
            Element root = textArea.getDocument().getDefaultRootElement();
            String text = "1" + System.getProperty("line.separator");
               for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                  text += i + System.getProperty("line.separator");
               }
            return text;
         }
         @Override
         public void changedUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
         @Override
         public void insertUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
         @Override
         public void removeUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
      });
      jsp.getViewport().add(textArea);
      jsp.setRowHeaderView(lines);
      add(jsp);
      setSize(400, 275);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static void main(String[] args) {
      new NumeritosNotepad();
   }
}
