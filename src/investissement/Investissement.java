package investissement;

import acteurs.Acteur;

public class Investissement{

    private String nom;
    private float valeur;
    private boolean disponible;
    private float rentabilite;
    private Acteur proprietaire;
    
    public Investissement(String nom, float valeur, float rentabilite, Acteur proprietaire){
        this.nom = nom;
        this.valeur = valeur;
        this.disponible = true;
        this.rentabilite = rentabilite;
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return this.nom;
    }

    public void setProprietaire(Acteur proprietaire){
        this.proprietaire = proprietaire;
    }

    public Acteur getProprietaire(){
        return this.proprietaire;
    }

    public float getValeur(){
        return this.valeur;
    }

    public boolean estDisponible(){
        return this.disponible;
    }
    
    public float getRentabilite(){
        return this.rentabilite;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public String toString(){
        if(this.disponible){
            return "L'investissement " + this.nom + " est disponible au prix de " + this.valeur + " EUR et a une rentabilité de " + this.rentabilite;
        }
        else{
            return "L'investissement " + this.nom + " n'est pas disponible, il est au prix de " + this.valeur + " EUR et a une rentabilité de " + this.rentabilite;
        }
    }
}
