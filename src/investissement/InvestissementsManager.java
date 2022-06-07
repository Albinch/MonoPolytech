package investissement;

import acteurs.Etat;
import plateau.Plateau;

import java.util.ArrayList;

public class InvestissementsManager {

    private ArrayList<Investissement> unusedInvestissements;

    public InvestissementsManager(){
        this.unusedInvestissements = new ArrayList<Investissement>();
    }

    public void createInvestissements(){

        Etat etat = Plateau.ETAT;

        unusedInvestissements.add(new Investissement("Rue de la paix", 500000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 200000, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 350000, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 500000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 200000, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 350000, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 500000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 200000, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 350000, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 500000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 200000, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 350000, 9, etat));

        etat.getInvestissements().addAll(unusedInvestissements);
    }

    public Investissement getUnusedInvestissement(){
        Investissement investissement = this.unusedInvestissements.get(0);
        this.unusedInvestissements.remove(investissement);
        return investissement;
    }

}
