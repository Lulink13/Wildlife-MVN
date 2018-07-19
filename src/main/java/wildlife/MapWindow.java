package wildlife;

/*
 * Classe MapWindow
 * 
 * 
 * 
 */


import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Speedbug
 */
public class MapWindow implements WindowListener {
    
    private JFrame frame;
    private MapPanel pane;
    private FlowLayout disposeur;
    private WildLifeGame theGame;
     
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    // 

    public MapWindow(WildLifeGame game) {
        frame = new JFrame();
        pane = new MapPanel(game.getMap(), this, game);
        disposeur = new FlowLayout();
        theGame = game;
        
        frame.addWindowListener(this);
        frame.setBounds(400, 10, 1000, 1000);
        frame.setTitle("Carte de jeu");
        pane.setLayout(disposeur);
        frame.add(pane);
                
        // frame.setVisible(true);
    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    public boolean showMe() {
        frame.setVisible(true);
        return true;
    }
    
    // Cacher la fenêtre
    public boolean hideMe() {
        frame.setVisible(false);
        return true;
    }
    
    /*
    public void paintMe() {
        pane.update();
    }
    */
    
    // Repeindre une case
    public void repaint(int x, int y) {
        pane.repaintCell(x, y);
    }
    
    // Réorganiser la fenêtre
    public void packMe() {
        frame.pack();
    }

    
    //
    // Interface WindowListener ////////////////////////////////////////////////
    //

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
