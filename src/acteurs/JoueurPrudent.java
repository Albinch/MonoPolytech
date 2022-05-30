package acteurs;

import plateau.*;

public class JoueurPrudent extends Joueur{
    public JoueurPrudent(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement(){

    }

    public void actionAntitrust(){

    }

    public String toString(){
        return super.toString() + "Il adoptera le comportement prudent";
    }
}
