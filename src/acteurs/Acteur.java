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

    public ArrayList<Investissement> getInvestissements(){
        return this.investissements;
    }

    public void setLiquide(float liquide){
        this.liquide = liquide;
    }

    public float getValeurPatrimoine(){
        float somme = 0;
        for(Investissement i : this.investissements){
            somme += i.getValeur();
        }
        return somme;
    }
    
    public String toString(){
        return "Joueur : " + this.nom + " possède " + this.liquide + "\n";
    }
}
