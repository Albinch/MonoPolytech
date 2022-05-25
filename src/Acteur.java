public class Acteur{
    private float liquide;
    private String nom;
    public Acteur(float liquide, String nom){
        
        this.liquide = liquide;
        this.nom = nom;
    }
    
    public float getLiquide(){
        return this.liquide;
    }
    
    public String toString(){
        return "Joueur : " + this.nom +"possede "+this.liquide;
    }
}
