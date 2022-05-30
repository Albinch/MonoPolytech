package plateau.cases;

import acteurs.*;
import plateau.Case;

public class Antitrust extends Case {

    public Antitrust(int index){
        super(index);
    }
    
    public void actionCase(Joueur j){
    
    //
    
    }
    
    public String toString() {
        return "la case '"+this.index + "est un Antitrust";
    }
}
