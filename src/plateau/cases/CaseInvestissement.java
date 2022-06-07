package plateau.cases;

import acteurs.Joueur;
import configuration.Configuration;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;
import main.Main;
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
        try{
            j.actionInvestissement(this.investissement);
        }catch(PasAssezDeLiquideException e){
            System.out.println("A voulu acheter, mais n'a pas assez de liquide. " + this.investissement.getNom() + " vaut " + this.investissement.getValeur() + "€, et " + j.getNom() + " n'a que " + j.getLiquide() + "€");
        }
    }
    
    public String toString() {
        return "Investissement (index : " + this.getIndex() + ")\n";
    }
}
