package plateau.cases;

import acteurs.Joueur;
import configuration.Configuration;
import main.Main;
import plateau.Case;

public class BureauFinancesPubliques extends Case {

    public BureauFinancesPubliques(int index){
        super(index);
    }

    @Override
    public void actionCase(Joueur j){

        Configuration currentConfig = Main.CONFIG.getCurrentConfig();
        j.payerBFP(currentConfig.isFoncier(), currentConfig.getPourcentageTaxes());

    }

    public String toString() {
        return "La case '"+ this.getIndex() + "est une case 'Bureau finances publiques'";
    }
}
