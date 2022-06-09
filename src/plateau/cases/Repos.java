package plateau.cases;

import acteurs.Joueur;
import plateau.Case;

public class Repos extends Case {

    public Repos(int index){
        super(index);
    }

    @Override
    public void actionCase(Joueur j){
    
    }
    
    public String toString() {
        return "Repos (index : " + this.getIndex() + ")\n";
    }
}
