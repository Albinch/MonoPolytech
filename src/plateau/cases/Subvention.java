package plateau.cases;

import acteurs.Joueur;
import plateau.Case;

public class Subvention extends Case {

    float amount;

    public Subvention(int index, float amount){
        super(index);
        this.amount = amount;
    }

    @Override
    public void actionCase(Joueur j){
        j.recevoirSubvention(this.amount);
    }
    
    public String toString() {
        return "La case '"+ this.getIndex() + "est une case 'Subvention'";
    }
}
