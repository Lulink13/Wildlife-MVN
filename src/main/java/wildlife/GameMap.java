package wildlife;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Speedbug & Lulu
 */
public class GameMap
{
    public static final int MAP_OUT = -1;
    public static final int MAP_SOL_NU = 0;
    public static final int MAP_PIERRE = 1;
    public static final int MAP_EAU = 2;
    public static final int MAP_HERBE = 3;
    public static final int MAP_BROUSSE = 4;
    public static final int MAP_FORET = 5;
    public static final int MAP_NEIGE = 6;
    public final int MAP_LONGUEUR = 100;
    public final int MAP_HAUTEUR = 100;
    
    private int gridMap[][] = new int[MAP_LONGUEUR][MAP_HAUTEUR];
    private boolean erreur = false;
    private String logErreur = "";
    
    
    //
    // Constructeur(s) /////////////////////////////////////////////////////////
    // 
    
    /**
     * Création d'une carte de jeu
     * @param nomFichierCarte Nom complet du fichier contenant la carte de jeu
     */
    public GameMap(String nomFichierCarte){
        // Chargement de la carte
        chargeCarte(nomFichierCarte);
    }
    
    
    //
    // SERVICES (fonctions publiques) //////////////////////////////////////////
    //
    public int natureEndroit(int x,int y){
        if (erreur) {
            // La carte n'est pas chargée
            logErreur = "La carte n'est pas chargée en mémoire";
            System.out.println("GameMap.natureEndroit : La carte n'est pas chargée en mémoire !");
            return MAP_OUT;
        }
        
        if (x >= 0 && x < MAP_LONGUEUR && y >= 0 && y < MAP_HAUTEUR) {
            // Les coordonnées sont acceptables
            return gridMap[x][y];
        }
        else {
            // Les coordonnées sont en dehors de la carte
            System.out.println("GameMap.natureEndroit : La case demandée n'existe pas !");
            return MAP_OUT;
        }
    }
    
    
    // Recherche de la nature d'un sol, à proximité d'une position
    public boolean closeTo(int natureSol, int x, int y) {
        
        for (int deltaX = -1 ; deltaX < 3 ; deltaX++) {
            for (int deltaY = -1 ; deltaY < 3 ; deltaY++) {
                if (x + deltaX >= 0 && x + deltaX < MAP_LONGUEUR &&
                        y + deltaY >= 0 && y + deltaY < MAP_HAUTEUR) {
                    if (this.natureEndroit(x, y) == natureSol) return true;
                }
            }
        }
        // Les cases ont toutes été parcourues, sans succès
        return false;
    }
    
    
    public boolean renvoieErreur(){
        return erreur;
    }
    
    
    public String renvoieLogErreur(){
        return logErreur;
    }
    
    
    public boolean resetErreur(){
        erreur = false;
        return true;
    }
    
    
    public boolean resetLogErreur(){
        logErreur = "";
        return true;
    }
    
    
    //
    // Méthodes (fonctions privées) ////////////////////////////////////////////
    //
    
    private boolean chargeCarte(String nomFichierCarte){
        final char SEPARATEUR = ';';
        int x,y;
        int intLu;
        char charLu;
        String chaineLue;
        String message;
        File fichierCarte;
        FileReader lecteurFichier;
        
        try
        {
            // Ouverture et lecture de fichier
            fichierCarte = new File(nomFichierCarte);
            lecteurFichier = new FileReader(fichierCarte);
            // Initialisations
            x = 0;
            y = 0;
            intLu = 0;
            chaineLue = "";
            while (intLu != -1)
            {
                intLu = lecteurFichier.read();
                //System.out.println(Integer.toString(intLu));
                if (intLu > 31)
                {
                    // Lecture d'un caractère
                    charLu = (char)intLu;
                    if (charLu == SEPARATEUR)
                    {
                        // Séparation entre deux valeurs, enregistrement dans le gridMap
                        gridMap[x][y] = Integer.parseInt(chaineLue);
                        message = "GRID (";
                        message = message.concat(Integer.toString(x)).concat(",");
                        message = message.concat(Integer.toString(y)).concat("): ");
                        message = message.concat(Integer.toString(gridMap[x][y]));
                        //System.out.println(message);
                        chaineLue = "";
                        // Incrémentation des coordonnées pour le prochain caractère
                        x++;
                        if (x >= MAP_LONGUEUR)
                        {
                            x = 0;
                            y++;
                            if (y >= MAP_HAUTEUR)
                            {
                                // Fin du remplissage du tableau, on simule la fin du fichier
                                intLu = -1;
                            }
                        }
                    }
                    else
                    {
                        chaineLue = chaineLue.concat(Character.toString(charLu));
                    }
                }
            }
        }
        catch (FileNotFoundException fileExcept) {
            // Erreur ! Le fichier n'existe pas ou n'est pas disponible
            erreur = true;
            logErreur = "Erreur ! Le fichier de carte de jeu n'existe pas ou n'est pas disponible.";
            //System.out.println("Erreur ! Le fichier de carte de jeu n'existe pas ou n'est pas disponible.");
            return false;
        }
        catch (IOException ioExcept) {
            // Erreur ! Impossible d'accéder aux données du fichier
            erreur = true;
            logErreur = "Erreur ! Impossible d'accéder aux données du fichier de carte de jeu.";
            //System.out.println("Erreur ! Impossible d'accéder aux données du fichier de carte de jeu.");
            return false;
        }
        // Fin de la lecture du fichier de carte
        erreur = false;
        logErreur = "";
        //System.out.println("Chargement de la carte réussi");
        return true;
    }

    
    //
    
}
