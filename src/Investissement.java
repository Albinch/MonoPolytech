public class Investissement{

    private String nom;
    private float valeur;
    private boolean disponible = false;
    private float rentabilite;
    
    public Investissement(String nom,float valeur,boolean disponible,float rentabilite){
        this.nom = nom;
        this.valeur = valeur;
        this.disponible = disponible;
        this.rentabilite = rentabilite;  
        }
        
    public float getValeurInv(){
        return this.valeur;
    }
    
    public float getRentabilite(){
        return this.rentabilite;
    }
    
    public boolean estDisponible(){
        return this.disponible;
    }
    
    public void setDisponible(boolean b){
        this.disponible = b;
    }
}
