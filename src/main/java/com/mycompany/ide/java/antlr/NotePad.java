/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ide.java.antlr;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebjaiovi
 */
public class NotePad extends JFrame implements ActionListener, WindowListener{
JTextPane jta = new JTextPane();
JTextArea jtaColoreado = new JTextArea();
    File fnameContainer;
    
    public NotePad(){
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
				
		setVisible(true);
	
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
		jta.setText("");
	
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
			
		while((l=d.readLine())!= null) {
			jta.setText(jta.getText()+l+"\r\n");
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
        
}
