package wildlife;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Jean-Christophe
 */
public class MapPanel extends JPanel {
    
    //
    // Constantes
    //
    public static final int BOX_WIDTH = 8;
    public static final int BOX_HEIGHT = 8;
    public static final int BORDER_WIDTH = 0;
    
    
    //
    // Champs privés ///////////////////////////////////////////////////////////
    //
    private GameMap carteJeu;
    private MapWindow winMap;
    private WildLifeGame game;
    private Dimension dimScreen;
    private int boxWidth;
    private int boxHeight;
    
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    //
    public MapPanel(GameMap gm, MapWindow win, WildLifeGame g) {
        carteJeu = gm;
        winMap = win;
        game = g;
        /*
        Dimension dim = new Dimension(gm.MAP_HAUTEUR * (BORDER_WIDTH + BOX_HEIGHT),
                                      gm.MAP_LONGUEUR * (BORDER_WIDTH + BOX_WIDTH));
        this.setPreferredSize(dim);
        */
        
        // Adaptation de la taille de la carte à l'écran, pour occuper 90% de la hauteur
        dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        boxHeight = (int) StrictMath.floor(0.90 * dimScreen.height / gm.MAP_HAUTEUR);
        boxWidth = boxHeight;
        
        // Calcul de la taille préférentielle de la JFrame
        Dimension dim = new Dimension(gm.MAP_HAUTEUR * (BORDER_WIDTH + boxHeight),
                                      gm.MAP_LONGUEUR * (BORDER_WIDTH + boxWidth));
        this.setPreferredSize(dim);

    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    public void update() {
        paintComponent(this.getGraphics());
    }
    
    
    // Repeindre une case de carte
    public void repaintCell(int mapX, int mapY) {

        this.repaint(boxWidth * mapX - boxWidth / 2, 
                     boxHeight * mapY - boxHeight / 2, 
                     2 * boxWidth, 
                     2 * boxHeight);
    }
    
    
    // Peindre la fenêtre
    @Override
    public void paintComponent(Graphics graphe) {
        super.paintComponent(graphe);

        int x,y;
        
        for (int mapY = 0 ; mapY < carteJeu.MAP_HAUTEUR ; mapY++) {
            
            for (int mapX = 0 ; mapX < carteJeu.MAP_LONGUEUR ; mapX++) {
                
                x = (BORDER_WIDTH + boxWidth) * mapX;
                y = (BORDER_WIDTH + boxHeight) * mapY;
                
                // Sélection de la couleur du carré en fonction de la nature du
                // sol enregistrée dans la carte de jeu
                switch(carteJeu.natureEndroit(mapX, mapY)) {
                    case (GameMap.MAP_SOL_NU):
                        graphe.setColor(Color.orange);
                        break;
                    case (GameMap.MAP_PIERRE):
                        graphe.setColor(Color.DARK_GRAY);
                        break;
                    case (GameMap.MAP_EAU):
                        graphe.setColor(Color.BLUE);
                        break;
                    case (GameMap.MAP_HERBE):
                        graphe.setColor(Color.GREEN);
                        break;
                    case (GameMap.MAP_BROUSSE):
                        graphe.setColor(Color.YELLOW);
                        break;
                    case (GameMap.MAP_FORET):
                        graphe.setColor(Color.getColor("BROWN"));
                        break;
                    case (GameMap.MAP_NEIGE):
                        graphe.setColor(Color.WHITE);
                        break;
                    default:
                        graphe.setColor(Color.BLACK);
                }
                // Dessin de la case
                graphe.fillRect(x, y, boxWidth, boxHeight);
            }
        }
        
        // Dessin des animaux
        Animal bete;
        graphe.setColor(Color.RED);
        graphe.setFont(new Font(" Times Roman ", Font.PLAIN, 9));
        
        for (int count = 0 ; count < game.getAnimalNumber() ; count++) {
            bete = game.getAnimal(count);
            if (bete != null) {
                //graphe.drawString(bete.symbolEspece(), (int)bete.getX(), (int)bete.getY());
                graphe.fillOval((int)StrictMath.floor(boxWidth * bete.getX() - boxWidth / 2), 
                                (int)StrictMath.floor(boxHeight * bete.getY() - boxHeight / 2), 
                                boxWidth, 
                                boxHeight);
            }
        }
        // Fin du dessin de la carte, on adapte la fenêtre au contenu
        winMap.packMe();
    }
    
    
    
    
}
