package wildlife;

/*
 * Class Tigre
 * 
 * inherits Carnivor, Animal
 * le test a marché!
 */


/**
 *
 * @author Speedbug
 */
public class Tigre extends Carnivor {
    
    //
    // Constantes //////////////////////////////////////////////////////////////
    //
    public static final int DEPENSE_ENERGIE_SOL_NU = 1;
    public static final int DEPENSE_ENERGIE_PIERRE = 2;
    public static final int DEPENSE_ENERGIE_EAU = 5;
    public static final int DEPENSE_ENERGIE_HERBE = 1;
    public static final int DEPENSE_ENERGIE_BROUSSE = 2;
    public static final int DEPENSE_ENERGIE_FORET = 2;
    public static final int DEPENSE_ENERGIE_NEIGE = 3;
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    //
    
    /**
     * 
     * @param dateNaissance Référence de temps
     */
    public Tigre(GameMap gm, long dateNaissance, int x, int y)
    {
        super(gm, dateNaissance);
        this.setEspece("Tigre");
        this.setSymbolEspece("T");
        this.setLocation(x, y);
        xDelta = 2;
        yDelta = 1;
    }
    
    
    public Tigre(GameMap gm, long dateNaissance, Tigre Pere, Tigre Mere)
    {
        super(gm, dateNaissance,Pere,Mere);
        this.setEspece("Tigre");
        this.setSymbolEspece("T");
        xDelta = 2;
        yDelta = 1;
    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    
    @Override
    public boolean joueSonTour() {
        
        //le tour précédent est terminé => je range les informations de ce dernier
        archiverLogTour();
        
        
        //System.out.println("Ok, je joue...");
        if (this.estVivant()) {
            ajoutLog("Ok, je joue !!!");
            // Emplacement du Tigre
            ajoutLog("Je suis à la position : (" + getX() + ";" + getY() + ")");

            // Comportement de Tigre
            /*
            if (this.getEnergie() > this.getHydratation()) {
                // J'ai plus soif que faim
                ajoutLog("j'ai plus soif que faim...");
            }
            else {
                // J'ai plus faim que soif
                ajoutLog("J'ai plus faim que soif...");
            }
            */
            // Déplacement
            if ((getX() + xDelta >= getGameMap().MAP_LONGUEUR) || (getX() + xDelta < 0)) {
                xDelta = xDelta * -1;
            } 
            if ((getY()+ yDelta >= getGameMap().MAP_HAUTEUR) || (getY() + yDelta < 0)) {
                yDelta = yDelta * -1;
            }
            this.setLocation(getX() + xDelta, getY() + yDelta);
            ajoutLog("Je me déplace vers la position : (" + getX() + ";" + getY() +")");
            // Dépense hydrique due au déplacement
            this.depenseHydrique(4);
            // Consommation
            if (getGameMap().closeTo(GameMap.MAP_EAU, getX(), getY())) {
                // Je suis près de l'eau, je bois si j'ai soif !
                ajoutLog("Je suis à côté de l'eau");
                if (getHydratation() < 80) {
                    this.boire();
                    ajoutLog("J'ai bu, mon hydratation est à : " + getHydratation());
                } else {
                    ajoutLog("Mais je n'ai pas vraiment soif");
                }

            }
        } else {
            ajoutLog("Je suis mort...");
        }
        return true;
    }
    
    
    //
    // Méthodes privées ////////////////////////////////////////////////////////
    //
    
}
