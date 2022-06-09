package investissement;

import acteurs.Etat;
import plateau.Plateau;

import java.util.ArrayList;

public class InvestissementsManager {

    private ArrayList<Investissement> unusedInvestissements;

    public InvestissementsManager(){
        this.unusedInvestissements = new ArrayList<Investissement>();
    }

    public void createInvestissements(float multiplicator){

        Etat etat = Plateau.ETAT;

        unusedInvestissements.add(new Investissement("Rue de la paix", 5000, 20 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Boulevard de la Villette", 730, 25 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Faubourg Saint-Honoré", 70, 10 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Société Générale", 4000000, 5 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Lamouret", 5340, 45 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Houndeton", 100, 20 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Alba", 4000000, 25 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Boulier", 5000, 3 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Perrin-Zen", 2376, 17 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Boutillier", 1500, 20 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue des potiers", 4000000, 5 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue de la soif", 9800, 25 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Wasielewski", 5000, 15 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue du Bitcoin", 1000000, 45 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue de la Tripel", 2000, 10 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue de la Quadrupel", 3500, 25 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Saucisson", 250, 10 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Karmeliet", 6000, 35 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Karting", 10000, 45 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue StatInf", 25000, 40 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Proba", 30000, 20 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Arras", 3000, 40 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Wizernes", 30000, 18 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Pierre Mauroy", 80000, 20 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Saint-Omer", 7000, 30 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Jeronimo", 250000, 15 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Java", 10000, 10 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Monopoly", 2500, 40 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Tatouage", 15000, 15 * multiplicator, etat));
        unusedInvestissements.add(new Investissement("Rue Elisa", 3000, 40 * multiplicator, etat));

        etat.getInvestissements().addAll(unusedInvestissements);
    }

    public Investissement getUnusedInvestissement(){
        Investissement investissement = this.unusedInvestissements.get(0);
        this.unusedInvestissements.remove(investissement);
        return investissement;
    }

}
