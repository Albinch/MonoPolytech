package Investissement;

public class Investissement{

    private String nom;
    private float valeur;
    private boolean disponible;
    private float rentabilite;
    
    public Investissement(String nom, float valeur, float rentabilite){
        this.nom = nom;
        this.valeur = valeur;
        this.disponible = true;
        this.rentabilite = rentabilite;  
    }

    public String getNom() {
        return nom;
    }

    public float getValeurInv(){
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
