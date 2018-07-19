package wildlife;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/**
 *
 * @author Lulink
 */
public class InputZone extends JTextArea implements KeyListener{
    
    private ConsoleWindow consWin;
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    // 

    public InputZone(ConsoleWindow cw) {
        consWin = cw;
        this.addKeyListener(this);
    }
        
    //
    // Interface KeyListener ///////////////////////////////////////////////////
    //
    @Override
    public void keyTyped(KeyEvent e) {
        String contenu;
        //ajouter le reset du texte
        if (e.getKeyChar() == Event.ENTER) {
            // Touche entrée appuyée
            contenu = this.getText();
            if (contenu.length() > 1) {
                consWin.input(contenu.substring(0, contenu.length() - 1));
            } 
            this.setText("");
        }
        else {
            // Autre touche
        }
        //consWin.input(e.getKeyChar());
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // Pas utile
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // Pas utile
    }

    
    //
    // Méthodes privées ////////////////////////////////////////////////////////
    //
    
}
