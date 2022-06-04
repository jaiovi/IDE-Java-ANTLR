/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ide.java.antlr;

//
// https://stackoverflow.com/questions/14400946/how-to-change-the-color-of-specific-words-in-a-jtextpane
//

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.*;

public class Test extends JFrame {
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

    public Test () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        final AttributeSet attrOrg = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.ORANGE);
        final SimpleAttributeSet attrBlack = new SimpleAttributeSet();
        StyleConstants.setForeground(attrBlack, Color.BLACK);
        StyleConstants.setBold(attrBlack, true);
        //cont.addAttribute(cont.getEmptySet(), StyleConstants.Bold, Color.BLACK);
        final AttributeSet attrSimple = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        //final AttributeSet attrBold = cont.addAttribute(cont.getEmptySet(),StyleConstants.CharacterConstants.Bold, Color.BLACK);
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
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false); //colorea rojo
                        }
                        else
                        {
                            if (text.substring(wordL, wordR).matches("(\\W)*(int)"))
                            {
                                setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); //colorea rojo
                            }
                            else
                            {
                                if (text.substring(wordL, wordR).matches("(\\W)*(write)"))
                                {
                                    setCharacterAttributes(wordL, wordR - wordL, attrBlack, false); //colorea rojo
                                }
                                else
                                {
                                    if (text.substring(wordL, wordR).matches("(\\W)*(1|2|3|4|5|6|7|8|9|0)"))
                                    {
                                        setCharacterAttributes(wordL, wordR - wordL, attrBlue, false); //colorea rojo
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
        JTextPane txt = new JTextPane(doc);
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
        setVisible(true);
    }

    public static void main (String args[]) {
        new Test();
    }
}
