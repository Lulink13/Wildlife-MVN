package wildlife;

/**
 *
 * @author Speedbug & Lulu
 */
abstract class Animal 
{
    /*
     * Caractéristiques des Animaux
     */

    // Identification
    private String nomEspece;
    private String symbolEspece;
    // Capacités
    private long dateNaissance;
    private int vitesseMaximale;
    private int vitesseMarche;
    private int champDeVision;
    // Sexe
    // 0:Male 1:Femelle
    private boolean sexe;
    // Position
    private int xPos;
    private int yPos;
    protected int xDelta;
    protected int yDelta;
    // Direction
    private long direction;
    // Facteurs physiques
    private boolean vivant;
    private int energie;
    private int hydratation;
    private int fatigue;
    private int fertilite;
    protected String log;
    protected String logTour;
    // Carte de jeu
    private GameMap gameMap;
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    //
    
    public Animal(GameMap gm, long dateDeNaissance)
    {
        // Animaux créés au début de la partie
        gameMap = gm;
        dateNaissance = System.currentTimeMillis();
        initSexe();
        vivant = true;
        energie = 70 + (int) (20 * Math.random());
        hydratation = 70 + (int) (20 * Math.random());
    }
    
    public Animal(GameMap gm, long dateDeNaissance, Animal Pere, Animal Mere)
    {
        // Animaux issus de la reproduction naturelle
        gameMap = gm;
        dateNaissance = System.currentTimeMillis();
        initSexe();
        xPos = Mere.xPos;
        yPos = Mere.yPos;
        vivant = true;
        energie = 80;
        hydratation = 80;
    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    public boolean setLocation(int x, int y) {
        if (x >= 0) {
            xPos = x;
            if (y >= 0) {
                yPos = y;
                return true;
            }
        }
        return false;
    }
    
    
    public int getX() {
        return xPos;
    }
    
    
    public int getY() {
        return yPos;
    }
    
    
    public boolean sexe() {
        return sexe;
    }
    
    
    public String espece() {
        return nomEspece;
    }

    
    public String symbolEspece() {
        return symbolEspece;
    }
    
    
    public String quiSuisJe() {
        
        String msg;
        // initialitation de msg
        msg = "";
        
        msg = msg + "Je viens de naitre, je suis un " + nomEspece + "!\n";
        msg = msg + "Ma date de naissance : " + dateNaissance + "\n";
        if (sexe == true) {
            msg = msg + "Je suis un mâle\n";
        } else {
            msg = msg + "Je suis une femelle\n";
        }
        msg = msg + "Energie : " + energie + "\n";
        msg = msg + "Hydratation : " + hydratation +"\n";
        msg = msg + "Fatigue : " + fatigue + "\n";
        msg = msg + "Fertilité : " + fertilite + "\n";
        return msg;
    }
    
    
    abstract public boolean joueSonTour();
    //abstract public boolean quiSuisJe();

    
    public boolean estVivant() {
        return vivant;
    }
    
    
    public int getEnergie() {
        return energie;
    }
    
    
    public int getHydratation() {
        return hydratation;
    }
    
    
    public boolean downEnergie(int step) {
        energie = energie - step;
        // Comportement en cas de baisse d'énergie à 0
        if (energie <= 0) {
            // L'animal meurt
            vivant = false;
        }
        return true;
    }
    
    
    public void setSymbolEspece(String s) {
        this.symbolEspece = s;
    }
    
    
    public boolean setEspece(String esp) {
        nomEspece = esp;
        return true;
    }
    

    public String lectureLog() {
        return log;
    }

    
    public String lectureLogTour() {
        return logTour;
    }
    
    
    protected GameMap getGameMap() {
        return gameMap;
    }
    
    
    protected boolean archiverLogTour() {
        log = log + logTour;
        logTour = "";
        return true;
    }
    
    
    public boolean resetLog() {
        log = "";
        return true;
    }
    
    
    public boolean ajoutLog(String info) {
        logTour = logTour + "\n" + info;
        return true;
    }
    
    
    public boolean boire() {
        do {
            hydratation = (int) StrictMath.floor(100 * StrictMath.random()) ;
        } while (hydratation < 85);
        return true;
    }
    
    
    public boolean depenseEnergie(int e) {
        if (e > 0 && e < 99) {
            energie -= e;
            if (energie < 0) {
                this.vivant = false;
            }
        } else {
            return false;
        }
        return true;
    }
    
    
    public boolean depenseHydrique(int h) {
        if (h > 0 && h < 99) {
            energie -= h;
            if (energie < 0) {
                this.vivant = false;
            }
        } else {
            return false;
        }
        return true;
    }

    
    //
    // Méthodes privées ////////////////////////////////////////////////////////
    //
    
    /*
     * Détermine le sexe de l'animal, au hazard
     */
    private void initSexe()
    {
        if(Math.random()<=0.5)
        {
            sexe = true;
        }
        else
        {
            sexe = false;
        }
    }
    
    
    private boolean combattre(Animal proie) 
    {
        
        return true;
    }
    
    
}
