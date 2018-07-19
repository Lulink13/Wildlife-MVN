package wildlife;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Speedbug & Lulu
 */
public class WildLifeGame 
{
    public final static int MODE_CONSOLE = 100;
    public final static int MODE_WINDOW = 101;
    
    private MapWindow winMap;
    private ConsoleWindow winCons;
    private boolean modeConsole;
    private GameMap carteDeJeu;
    private Animal[] tableDesAnimaux;
    
    private int nombreMaxAnimaux;
    private final float proportionTigre = (float)0.6;
    private boolean runGame;

    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    //
    
    /**
     * @param 
     * @return Rien, c'est un constructeur
     */
    public WildLifeGame(int nombreAnimaux, int modeDuJeux) {
        
        int count;
        winCons = new ConsoleWindow(this);
        
        // Sélection du mode de jeu
        setGameMode(modeDuJeux);
        
        // Création de la carte de jeu
        carteDeJeu = new GameMap("");
        if (carteDeJeu.renvoieErreur() == true) {
            winCons.print(carteDeJeu.renvoieLogErreur());
            carteDeJeu.resetErreur();
            carteDeJeu.resetLogErreur();
        }
        
        // Création de la fenêtre graphique
        winMap = new MapWindow(this);
        if (winMap == null) {
            // petit problème avec la fenêtre qui doit présenter la carte !
            setGameMode(WildLifeGame.MODE_CONSOLE);
            winCons.print("Probleme avec la fenêtre de carte de jeu...");
        }
        
        // Affichage des fenêtres
        if (modeConsole == false) {
            winMap.showMe();
        }
        winCons.showMe();
        
        // Création des individus originels
        if (modeConsole) {
            winCons.print("Création des animaux...");
            //System.out.println("Création des animaux...");
        }
        nombreMaxAnimaux = 5 * nombreAnimaux;
        tableDesAnimaux = new Animal[nombreMaxAnimaux];
        // Création des Tigres
        for (count = 0 ; count < (int) StrictMath.floor(nombreAnimaux * proportionTigre) ; count++) {
            int x = -1, y = -1; 
            while (x < 0 || x >= carteDeJeu.MAP_LONGUEUR) {
                x = (int) StrictMath.floor(100 * StrictMath.random()) ;
            } 
                
            while (y < 0 || y >= carteDeJeu.MAP_HAUTEUR) {
                y = (int) StrictMath.floor(100 * StrictMath.random());
            } 
            
            tableDesAnimaux[count] = new Tigre(carteDeJeu, (long)0, x, y);
            winCons.print(tableDesAnimaux[count].quiSuisJe());
        }
    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    /*
     * Lance le jeu
     */
    public boolean runGame()
    {
        int indexAnimaux;               // index de l'animal qui joue
        int tourDeJeu;                  // numéro du tour de jeu
        long heureDebutTourDeJeu;       // heure de début de la boucle
        
        tourDeJeu = 0;
        runGame = true;
        do  {
            heureDebutTourDeJeu = System.currentTimeMillis();
            winCons.print("\n------[Début du tour n°" + tourDeJeu + "]------");
            // System.out.println("------[Début du tour n°" + tourDeJeu + "]------");
            for (indexAnimaux = 0 ; indexAnimaux < nombreMaxAnimaux ; indexAnimaux++ ) {
                if (tableDesAnimaux[indexAnimaux] != null) {
                    // C'est le tour de cet animal de jouer
                    if (modeConsole) {
                        winCons.print("C'est à l'animal " + indexAnimaux + " de jouer...");
                    }
                    // Test animal vivant
                    if (tableDesAnimaux[indexAnimaux].estVivant() == false) {
                        // L'animal est mort !
                        winCons.print("L'animal n°" + indexAnimaux + " est mort !!!");
                        //tableDesAnimaux[indexAnimaux] = null;
                    }
                    // Repeint la carte de jeu pour faire 'bouger' les animaux
                    winMap.repaint(tableDesAnimaux[indexAnimaux].getX(), tableDesAnimaux[indexAnimaux].getY());
                    // Joue !
                    tableDesAnimaux[indexAnimaux].joueSonTour();
                    // Affiche la position de l'animal dans la console
                    winCons.print(tableDesAnimaux[indexAnimaux].lectureLogTour());
                    // Repeint la carte de jeu pour faire 'bouger' les animaux
                    winMap.repaint(tableDesAnimaux[indexAnimaux].getX(), tableDesAnimaux[indexAnimaux].getY());
                }
            }
            /*
            // Repeindre la carte de jeu pour faire évoluer les animaux
            winMap.paintMe();
            */
            
            // Calcul du temps du tour de jeu
            winCons.print("Durée du temps de travail : " +
                    ((System.currentTimeMillis() - heureDebutTourDeJeu) / 1000) + "secondes");
            //System.out.println("Durée du temps de travail : " + ((System.currentTimeMillis() - heureDebutTourDeJeu) / 1000) + "secondes" );
            // Attente pour obtenir un tour en 1 seconde
            do {
                // Attente pour obtenir au minimum 1 seconde de tour de jeu
            } while (System.currentTimeMillis() < heureDebutTourDeJeu + 1000);

            
            
            // Incrémentation au numéro de tour suivant
            tourDeJeu++;
            /*
            if (tourDeJeu >= 50) {
                runGame = false;
            }
            */
            
        } while(runGame);
        winMap.hideMe();
        winMap = null;
        winCons.hideMe();
        winCons = null;
        return true;
    }
    
    
    /*
     * Ferme le jeu définitivement
     */
    public boolean endGame() {
        runGame = false;
        return true;
    }
    
    
    /*
     * Positionne le jeu en mode CONSOLE (TEXTE)
     */
    public final void setGameMode(int mode)
    {
        switch (mode) {
            case WildLifeGame.MODE_CONSOLE:
                modeConsole = true;
                break;
            case WildLifeGame.MODE_WINDOW:
                modeConsole = false;
                break;
        }
        if (modeConsole) {
            System.out.println("Le jeu fonctionne en mode console...");
        }
    }
    
    
    /*
     * Renvoie un objet GameMap contenant les données de la carte de jeu
     */
    public GameMap getMap() {
        return carteDeJeu;
    }
    
    
    public int getAnimalNumber() {
        if (tableDesAnimaux != null) {
            return tableDesAnimaux.length;
        }
        return -1;
    }
    
    public Animal getAnimal(int count) {
        return tableDesAnimaux[count];
    }
    
    
    //
    // Méthodes privées ////////////////////////////////////////////////////////
    //
    
}
