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

        unusedInvestissements.add(new Investissement("Rue de la paix", 2000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 3000, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 1500, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 500, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 12, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 3870, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 2000, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 11, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 2376, 9, etat));
        unusedInvestissements.add(new Investissement("Rue de la paix", 300, 10, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 1600, 8, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 9800, 9, etat));

        etat.getInvestissements().addAll(unusedInvestissements);
    }

    public Investissement getUnusedInvestissement(){
        Investissement investissement = this.unusedInvestissements.get(0);
        this.unusedInvestissements.remove(investissement);
        return investissement;
    }

}
