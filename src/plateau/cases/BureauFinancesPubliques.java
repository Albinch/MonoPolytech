package plateau.cases;

import acteurs.Joueur;
import configuration.Configuration;
import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;
import main.Main;
import plateau.Case;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
            System.out.println("Il manque " + e.getRAP() + "€ à " + j.getNom() + " pour payer la BFP. Il va devoir vendre des biens.");

            int montantRecolte = 0;

            while(montantRecolte < e.getRAP()){
                Investissement toSell = j.getInvestissements().get(0);
                montantRecolte++;
                j.vendre(toSell);
                System.out.println("- " + toSell.getNom() + " pour " + toSell.getValeur() + "€.");
            }

            System.out.println(j.getNom() + " a vendu pour " + montantRecolte + "€.");

        }catch(NePeutPasPayerException e){
            j.eliminer();
        }
    }

    public String toString() {
        return "BFP (index : " + this.getIndex() + ")\n";
    }
}
