package acteurs;

public class Etat extends Acteur{
    public Etat(float liquide, String nom){
        super(liquide, nom);
    }

    public String toString(){
        return "Ce joueur est l'état. " + super.toString();
    }
}
