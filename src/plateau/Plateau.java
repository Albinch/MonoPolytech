package plateau;

import investissement.Investissement;
import investissement.InvestissementsManager;
import plateau.cases.*;
import acteurs.Etat;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {

    private InvestissementsManager im;

    public static Etat ETAT;
    public static ArrayList<Case> CASES;
    public static int NBCASES = 40;
    private int nbCasesAntitrust = 0;
    private int nbCasesBFP = 0;
    private int nbCasesRepos = 0;
    private int nbCasesSubvention = 0;
    private int nbCasesInvestissement = 0;

    public Plateau(int NBCASES, InvestissementsManager im){
        this.NBCASES = NBCASES;
        this.CASES = new ArrayList<Case>();
        this.im = im;
    }

    public void generatePlateau(){

        this.ETAT = new Etat(100000, "Etat");

        for(int i = 0; i < this.NBCASES; i++){
            int random = new Random().nextInt(5);
            switch(random){

                case 0:
                    this.CASES.add(new Antitrust(i));
                    this.nbCasesAntitrust++;
                    break;
                case 1:
                    this.CASES.add(new BureauFinancesPubliques(i));
                    this.nbCasesBFP++;
                    break;
                case 2:
                    this.CASES.add(new CaseInvestissement(i, im.getUnusedInvestissement()));
                    this.nbCasesInvestissement++;
                    break;
                case 3:
                    this.CASES.add(new Repos(i));
                    this.nbCasesRepos++;
                    break;
                case 4:
                    int amount = 1000 - new Random().nextInt(500);
                    this.CASES.add(new Subvention(i, amount));
                    this.nbCasesSubvention++;
                    break;

            }
        }
    }

    public String toString(){
        return "Plateau de " + this.NBCASES + " CASES, comportant : " + this.nbCasesSubvention + " CASES 'Subvention', " + this.nbCasesRepos + " CASES 'Repos', " +
                this.nbCasesBFP + " CASES 'BFP', " + this.nbCasesAntitrust + " CASES 'Antitrust', " + this.nbCasesInvestissement + " CASES 'Investissement'";
    }

}
