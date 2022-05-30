package investissement;

import java.util.ArrayList;

public class InvestissementsManager {

    private ArrayList<Investissement> unusedInvestissements;

    public InvestissementsManager(){
        this.unusedInvestissements = new ArrayList<Investissement>();
    }

    public void createInvestissements(){

        unusedInvestissements.add(new Investissement("Rue de la paix", 500000, 10));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 200000, 8));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 350000, 9));

    }

    public Investissement getUnusedInvestissement(){
        Investissement investissement = this.unusedInvestissements.get(0);
        this.unusedInvestissements.remove(investissement);
        return investissement;
    }

}
