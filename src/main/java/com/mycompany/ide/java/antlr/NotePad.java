/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ide.java.antlr;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
        
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import ANTLR.*;

/**
 * GEEKS FOR GEEKS
 * @author sebjaiovi
 */
public class NotePad extends JFrame implements ActionListener, WindowListener{
    //JTextPane jta = new JTextPane();
    //JTextArea jta = new JTextArea();
    private static JTextArea jta;
    private static JTextPane txt;
    JTextArea jtaColoreado = new JTextArea();
    private static JTextArea lines; //numeritos
    File fnameContainer;
    
    Translator translator = new Translator();

    private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    
    public NotePad(){
        //Definicion de area de texto y numero de linea
        jta = new JTextArea();
        lines = new JTextArea("1");
        lines.setBackground(Color.LIGHT_GRAY);
        lines.setEditable(false);
        //Definimos font normal
        Font fnt=new Font("Arial",Font.PLAIN,15);
        Container con=getContentPane();

        //interfaz grafica PT1
        JMenuBar jmb=new JMenuBar();
        JMenu jmfile = new JMenu("Archivo");
        JMenu jmedit = new JMenu("Editar");
        JMenu jmide = new JMenu("IDE");
        JMenu jmhelp = new JMenu("Ayuda");

        con.setLayout(new BorderLayout());
        JScrollPane sbrText = new JScrollPane(jta);
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbrText.setVisible(true);

        //definimos en general font
        jta.setFont(fnt);
        //DEL TEXT AREA, reemplazado por PANE
        //jta.setLineWrap(true);
        //jta.setWrapStyleWord(true);

        //donde el container recibe nuestra caja de texto especificada
        con.add(sbrText);

        //Atributos del resaltador 

        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        final AttributeSet attrOrg = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.ORANGE);
        final SimpleAttributeSet attrBlack = new SimpleAttributeSet();
        StyleConstants.setForeground(attrBlack, Color.BLACK);
        StyleConstants.setBold(attrBlack, true);
        final AttributeSet attrSimple = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);

        //mas de la gui
        createMenuItem(jmfile,"Nuevo");
        createMenuItem(jmfile,"Abrir");
        createMenuItem(jmfile,"Guardar");
        jmfile.addSeparator();
        createMenuItem(jmfile,"Salir");

        createMenuItem(jmedit,"Cortar");
        createMenuItem(jmedit,"Copiar");
        createMenuItem(jmedit,"Pegar");

        createMenuItem(jmide, "Correr");

        createMenuItem(jmhelp,"Creditos");

        jmb.add(jmfile);
        jmb.add(jmedit);

        jmb.add(jmide);

        jmb.add(jmhelp);

        setJMenuBar(jmb);
        setIconImage(Toolkit.getDefaultToolkit().getImage("notepad.gif"));
        addWindowListener(this);
        setSize(500,500);
        setTitle("SinTitulo.txt - MatricesIDE");

        //adicional para reportar DEBUGGING del compilado

        String notifica = "Hola";
        // create the status bar panel and shove it down the bottom of the frame https://stackoverflow.com/questions/3035880/how-can-i-create-a-bar-in-the-bottom-of-a-java-app-like-a-status-bar
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        con.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(con.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel(""+notifica); //varible a modificar
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
                
        
        //Redaltador chan
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(matriz)"))
                        {
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false); //colorea negro y negritas
                        }
                        else
                        {
                            if (text.substring(wordL, wordR).matches("(\\W)*(int)"))
                            {
                                setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); //colorea azul
                            }
                            else
                            {
                                if (text.substring(wordL, wordR).matches("(\\W)*(write)"))
                                {
                                    setCharacterAttributes(wordL, wordR - wordL, attrBlack, false); //colorea negro y negritas
                                }
                                else
                                {
                                    if (text.substring(wordL, wordR).matches("(\\W)*(1|2|3|4|5|6|7|8|9|0)"))
                                    {
                                        setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); //colorea azul
                                    }
                                    else
                                    {
                                        setCharacterAttributes(wordL, wordR - wordL, attrSimple, false); //no le hace nada   
                                    }
                                }
                            }
                        }
                        wordL = wordR;
                    }
                    wordR++;
                }
                
                System.out.println("Hola");
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*(matriz)")) {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                } else {
                    
                    if (text.substring(before, after).matches("(\\W)*(int)")) 
                    {
                        setCharacterAttributes(before, after - before, attrBlue, false);
                    }
                    else
                    {
                        if (text.substring(before, after).matches("(\\W)*(witre)")) 
                        {
                            setCharacterAttributes(before, after - before, attrBlack, false);
                        }
                        else
                        {
                            if(text.substring(before, after).matches("(\\W)*(1|2|3|4|5|6|7|8|9|0)"))
                            {
                                setCharacterAttributes(before, after - before, attrBlue, false);
                            }
                            else
                            {
                                setCharacterAttributes(before, after - before, attrSimple, false);
                            }
                        }
                    }
                }
            }
        };
        
        txt = new JTextPane(doc);
        /*txt.setText("{ \n" +
        "matriz A, B, R1, R2, R3; \n" +
        "A = [ 2, 0, 1; 3, 0, 0; 5, 1, 1 ]; \n" +
        "B = [ 1, 0, 1; 1, 2, 1; 1, 1, 0 ]; \n" +
        "R1 = A + B; \n" +
        "R2 = A - B; \n" +
        "R3 = R2^ + R1; \n" +
        "write R3; \n" +
        "}");*/
        JScrollPane txtRes = new JScrollPane(txt);
        add(txtRes);
        setVisible(true);
      
        //  Code to implement line numbers inside the JTextArea
        jta.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
                System.out.println("Hola");
                int caretPosition = jta.getDocument().getLength();
                Element root = jta.getDocument().getDefaultRootElement();
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
      
        /*JTextPane txt = new JTextPane(doc);
        txt.setText("{ \n" +
        "matriz A, B, R1, R2, R3; \n" +
        "A = [ 2, 0, 1; 3, 0, 0; 5, 1, 1 ]; \n" +
        "B = [ 1, 0, 1; 1, 2, 1; 1, 1, 0 ]; \n" +
        "R1 = A + B; \n" +
        "R2 = A - B; \n" +
        "R3 = R2^ + R1; \n" +
        "write R3; \n" +
        "}");
        add(new JScrollPane(txt));
        setVisible(true);*/

        /*sbrText.getViewport().add(jta);
        sbrText.setRowHeaderView(lines);
        add(sbrText);
        setSize(400, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);*/

        //Generar Terminal : codigo trabaj
    }
    

    public void createMenuItem(JMenu jm,String txt){ //snippet que crea los accionables de cada menu
        JMenuItem jmi=new JMenuItem(txt);
        jmi.addActionListener(this);
        jm.add(jmi);
    }
	
    public void actionPerformed(ActionEvent e){	
        JFileChooser jfc=new JFileChooser();

        if(e.getActionCommand().equals("Nuevo")){ 
            //new
            this.setTitle("SinTitulo.txt - MatricesIDE");
            jta.setText("");
            fnameContainer=null;
        }else if(e.getActionCommand().equals("Abrir")){
            //open
            int ret=jfc.showDialog(null,"Abrir");

            if(ret == JFileChooser.APPROVE_OPTION)
            {
                try{
                    File fyl=jfc.getSelectedFile();
                    OpenFile(fyl.getAbsolutePath());
                    this.setTitle(fyl.getName()+ " - MatricesIDE");
                    fnameContainer=fyl;
                }catch(IOException ers){}
            }

        }else if(e.getActionCommand().equals("Guardar")){
            //save
            if(fnameContainer != null){
                jfc.setCurrentDirectory(fnameContainer);		
                jfc.setSelectedFile(fnameContainer);
            }
            else {
                //jfc.setCurrentDirectory(new File("."));
                jfc.setSelectedFile(new File("SinTitulo.txt"));
            }

            int ret=jfc.showSaveDialog(null);

            if(ret == JFileChooser.APPROVE_OPTION){
                try{

                    File fyl=jfc.getSelectedFile();
                    SaveFile(fyl.getAbsolutePath());
                    this.setTitle(fyl.getName()+ " - MatricesIDE");
                    fnameContainer=fyl;

                }catch(Exception ers2){}
            }	
        }else if(e.getActionCommand().equals("Salir")){
            Exiting();
        }else if(e.getActionCommand().equals("Copiar")){
            jta.copy();
        }else if(e.getActionCommand().equals("Pegar")){
            jta.paste();
        }else if(e.getActionCommand().equals("Correr")){ 
            // Llamando al traductor de lenguaje y ejecutor del codigo
            translator.updateCheck(txt.getText());
            compilar("Programa");
        }else if(e.getActionCommand().equals("Creditos")){ 
            JOptionPane.showMessageDialog(this,"MatricesIDE - Created by: Geeks for Geeks (https://www.geeksforgeeks.org/)","Notepad",JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getActionCommand().equals("Cortar")){
            jta.cut();
        }
    }
	
    public void OpenFile(String fname) throws IOException {	
        //open file code here
        BufferedReader d=new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
        String l;
        //clear the textbox
        txt.setText("");

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        while((l=d.readLine())!= null) {
            txt.setText(txt.getText()+l+"\r\n");
        }

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        d.close();
    }
	
    public void SaveFile(String fname) throws IOException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DataOutputStream o=new DataOutputStream(new FileOutputStream(fname));
        o.writeBytes(jta.getText());
        o.close();		
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
	
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowClosing(WindowEvent e) {
        Exiting();
    }
    public void windowOpened(WindowEvent e){}
    public void Exiting() {
            System.exit(0);
    }
        
    //FUNCIONALIDADES
    public String compilar(String nombreArchivo){
        
        String mensaje = "Traduccion Abortada";
        String errores = "";
        if(!translator.lexerErrorsPos().isEmpty()){
            errores += "ERRORES LEXICOS\n";
            for (int i = 0; i < translator.lexerErrorsPos().size(); i++) {
                errores += "Linea (" + translator.lexerErrorsPos().get(i) + "): ";
                errores += translator.lexerErrorsMsg().get(i) + "\n";
            }
        }
        if(!translator.parserErrorsPos().isEmpty()){
            errores += "ERRORES SINTACTICOS\n";
            for (int i = 0; i < translator.parserErrorsPos().size(); i++) {
                errores += "Linea (" + translator.parserErrorsPos().get(i) + "): ";
                errores += translator.parserErrorsMsg().get(i) + "\n";
            }
        }
        
        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(this,errores,"Traduccion Abortada",JOptionPane.INFORMATION_MESSAGE);
            return "ERROR - Problemas en el codigo fuente";
        }
        
        if (translator.translate("nombreArchivo")) {
            //
            // Imprimiendo resultado en panales
            for (int [][] mat : translator.outputs) {
                System.out.println("Matriz: ");
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[i].length; j++) {
                            System.out.print(mat[i][j] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("");
            }
            //
            return translator.translation;
        }
        else {
            errores += "ERROR SEMANTICO\n";
            errores += "Linea (" + translator.semanticErrorPos + "): " + translator.semanticErrorMsg;
            JOptionPane.showMessageDialog(this,errores,"Traduccion Abortada",JOptionPane.INFORMATION_MESSAGE);
            return "ERROR - Problemas en el codigo fuente";
        } 
    }
        
}
