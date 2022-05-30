package plateau.cases;

import acteurs.Joueur;
import plateau.Case;

public class Repos extends Case {

    public Repos(int index){
        super(index);
    }
    
    public void actionCase(Joueur j){
    
    //
    
    }
    
    public String toString() {
        return "La case '" + this.getIndex() + " est une case repos";
    }
}
