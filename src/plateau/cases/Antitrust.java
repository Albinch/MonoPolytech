package plateau.cases;

import acteurs.*;
import plateau.Case;

public class Antitrust extends Case {

    public Antitrust(int index){
        super(index);
    }

    @Override
    public void actionCase(Joueur j){
    
        Configuration currentConfig = Main.CONFIG.getCurrentConfig();
        j.actionAntitrust();
    }
    
    public String toString() {
        return "La case '" + this.getIndex() + " est une case 'Antitrust'";
    }
}
