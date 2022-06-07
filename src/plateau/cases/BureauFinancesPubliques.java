package plateau.cases;

import acteurs.Joueur;
import configuration.Configuration;
import exceptions.PasAssezDeLiquideException;
import main.Main;
import plateau.Case;

public class BureauFinancesPubliques extends Case {

    public BureauFinancesPubliques(int index){
        super(index);
    }

    @Override
    public void actionCase(Joueur j){

        Configuration currentConfig = Main.CONFIG.getCurrentConfig();

        try{
            j.payerBFP(currentConfig.isFoncier(), currentConfig.getPourcentageTaxes());
            System.out.println("Foncier : " + currentConfig.isFoncier() + " -- Taxes: " + currentConfig.getPourcentageTaxes() + "%");
        }catch(PasAssezDeLiquideException e){
            System.out.println(j.getNom() + " n'a pas assez de liquide pour payer.");
        }
    }

    public String toString() {
        return "BFP (index : " + this.getIndex() + ")\n";
    }
}
