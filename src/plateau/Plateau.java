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
    private ArrayList<Case> cases;
    private int nbCases = 40;
    private int nbCasesAntitrust = 0;
    private int nbCasesBFP = 0;
    private int nbCasesRepos = 0;
    private int nbCasesSubvention = 0;
    private int nbCasesInvestissement = 0;

    public Plateau(int nbCases, InvestissementsManager im){
        this.nbCases = nbCases;
        this.cases = new ArrayList<Case>();
        this.im = im;
    }

    public void generatePlateau(){

        this.ETAT = new Etat(100000, "Etat");

        for(int i = 0; i < this.nbCases; i++){
            int random = new Random().nextInt(5);
            switch(random){

                case 0:
                    this.cases.add(new Antitrust(i));
                    this.nbCasesAntitrust++;
                    break;
                case 1:
                    this.cases.add(new BureauFinancesPubliques(i));
                    this.nbCasesBFP++;
                    break;
                case 2:
                    this.cases.add(new CaseInvestissement(i, im.getUnusedInvestissement()));
                    this.nbCasesInvestissement++;
                    break;
                case 3:
                    this.cases.add(new Repos(i));
                    this.nbCasesRepos++;
                    break;
                case 4:
                    int amount = (int) 1000 - new Random().nextInt(500);
                    this.cases.add(new Subvention(i, amount));
                    this.nbCasesSubvention++;
                    break;

            }
        }
    }

    public String toString(){
        return "Plateau de " + this.nbCases + " cases, comportant : " + this.nbCasesSubvention + " cases 'Subvention', " + this.nbCasesRepos + " cases 'Repos', " +
                this.nbCasesBFP + " cases 'BFP', " + this.nbCasesAntitrust + " cases 'Antitrust', " + this.nbCasesInvestissement + " cases 'Investissement'";
    }

}
