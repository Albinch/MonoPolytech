package acteurs;

import plateau.*;

public class Joueur extends Acteur implements StyleJoueur{

    private Case currentCase;

    public Joueur(float liquide, String nom, Case currentCase){
        super(liquide, nom);
        this.currentCase = currentCase;
    }

    public void actionInvestissement(){

    }

    public void actionAntitrust(){

    }

}