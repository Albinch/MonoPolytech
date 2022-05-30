package acteurs;

import investissement.*;
import java.util.ArrayList;

public class Acteur{

    private float liquide;
    private String nom;
    private ArrayList<Investissement> investissements;

    public Acteur(float liquide, String nom){
        this.liquide = liquide;
        this.nom = nom;
        this.investissements = new ArrayList<Investissement>();
    }
    
    public float getLiquide(){
        return this.liquide;
    }
    
    public String toString(){
        return "Joueur : " + this.nom + " possède " + this.liquide + "\n";
    }
}
