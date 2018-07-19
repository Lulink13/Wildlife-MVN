package wildlife;

/*
 * Classe ConsoleWindow
 * 
 * 
 * 
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
// import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JScrollPane;


/**
 *
 * @author Speedbug
 */
public class ConsoleWindow implements WindowListener {
    
    // Membres spécialisés dans le graphisme
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollP;
    private JTextArea textArea;
    private JTextArea inputArea;
    private BorderLayout disposeur;
    
    private WildLifeGame theGame;
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    // 

    public ConsoleWindow(WildLifeGame game) {
        theGame = game;
        frame = new JFrame();
        panel = new JPanel();
        textArea = new JTextArea();
        inputArea = new InputZone(this);
        scrollP = new JScrollPane(textArea);
        disposeur = new BorderLayout();
        
        // Propriétés du Panel
        panel.setLayout(disposeur);
        panel.add(scrollP, BorderLayout.CENTER);
        panel.add(inputArea, BorderLayout.SOUTH);

        // Propriétés de la textArea et de son ScrollPane
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        
        // Propriétés de la fenêtre
        frame.setBounds(10, 10, 300, 500);
        frame.setTitle("Console");
        frame.add(panel, BorderLayout.CENTER);
        textArea.append("-----[CONSOLE]-----\n\n");
        
        // ajout de l'écouteur
        frame.addWindowListener(this);
    }

    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    public boolean showMe(){
        frame.setVisible(true);
        return true;
    }
    
    public boolean hideMe(){
        frame.setVisible(false);
        return true;
    }
    
    public boolean print(String texte){
        textArea.append(texte + "\n");
        return true;
    }

    // Fonction qui renvoie le contenu du JTextArea qui accueille les commandes
    // de l'utilisateur
    public void input(String texte) {
        System.out.println(texte);
        if ("/quit".equals(texte) || "/QUIT".equals(texte)) {
            // Fin du jeu
            theGame.endGame();
        }
    }
    
    
    //
    // Interface WindowListener ////////////////////////////////////////////////
    //

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        theGame.endGame();
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
