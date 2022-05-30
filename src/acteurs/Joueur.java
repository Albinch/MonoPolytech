package acteurs;

import plateau.*;

public abstract class Joueur extends Acteur implements StyleJoueur{

    private Case currentCase;

    public Joueur(float liquide, String nom, Case currentCase){
        super(liquide, nom);
        this.currentCase = currentCase;
    }

    public abstract void actionInvestissement();

    public abstract void actionAntitrust();

    public void acheter(){

    }

    public void vendre(){

    }

    public void payerBFP(){

    }

    public void recevoirSubvention(){

    }

    public String toString(){
        return super.toString() + ". Ce joueur est tombé sur la case : " + this.currentCase + "\n";
    }

}