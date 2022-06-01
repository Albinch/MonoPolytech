package plateau.cases;

import acteurs.Joueur;
import investissement.Investissement;
import plateau.Case;

public class CaseInvestissement extends Case {

    private final Investissement investissement;

    public CaseInvestissement(int index, Investissement investissement){
        super(index);
        this.investissement = investissement;
    }

    @Override
    public void actionCase(Joueur j){
        Configuration currentConfig = Main.CONFIG.getCurrentConfig();
        j.actionInvestissement();
    }
    
    public String toString() {
        return "La case '" + this.getIndex() + " est une case 'Investissement'";
    }
}
