package plateau.cases;

import acteurs.Joueur;
import plateau.Case;

public class BureauFinancesPubliques extends Case {

    public BureauFinancesPubliques(int index){
        super(index);
    }

    @Override
    public void actionCase(Joueur j){



    }

    public String toString() {
        return "La case '"+ this.getIndex() + "est une case 'Bureau finances publiques'";
    }
}
