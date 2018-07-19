package wildlife;

/**
 *
 * @author Speedbug & Lulu
 */
abstract class Carnivor extends Animal 
{
    /*
     * Caractéristiques des carnivores
     */
    
    // Capacités
    private int aptitudeChasse;

    
    /*
     * 
     */
    public Carnivor(GameMap gm, long dateDeNaissance)
    {
        super(gm, dateDeNaissance);
    }
    
    public Carnivor(GameMap gm, long dateDeNaissance, Animal Pere, Animal Mere)
    {
        super(gm, dateDeNaissance, Pere, Mere);
    }
    
    
}
