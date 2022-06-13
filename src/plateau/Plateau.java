package plateau;

import configuration.ConfigurationManager;
import investissement.Investissement;
import investissement.InvestissementsManager;
import plateau.cases.*;
import acteurs.Etat;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {

    private InvestissementsManager im;

    public static Etat ETAT = new Etat(100000, "Etat");
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
        int casesRemplies = 0;
        int casesRestantes = this.NBCASES;

        this.CASES.add(new Repos(0));
        this.nbCasesRepos++;
        casesRemplies++;
        casesRestantes--;

        this.nbCasesInvestissement = (int)(casesRestantes * 0.75);
        for(int i = 1; i < this.nbCasesInvestissement; i++) {
            this.CASES.add(new CaseInvestissement(i, im.getUnusedInvestissement()));
        }
        casesRemplies += this.nbCasesInvestissement;

        for(int j = casesRemplies - 1; j < this.NBCASES; j++) {
            int random = new Random().nextInt(4);
            switch (random) {

                case 0:
                    this.CASES.add(new Antitrust(j));
                    this.nbCasesAntitrust++;
                    break;
                case 1:
                    this.CASES.add(new BureauFinancesPubliques(j));
                    this.nbCasesBFP++;
                    break;
                case 2:
                    this.CASES.add(new Repos(j));
                    this.nbCasesRepos++;
                    break;
                case 3:
                    int amount = 1000 - new Random().nextInt(500);
                    this.CASES.add(new Subvention(j, amount));
                    this.nbCasesSubvention++;
                    break;
            }
        }

        System.out.println("Un plateau de " + this.getNBCASES() + " case(s) a été généré.");
    }

    public String toString(){
        return "Plateau de " + this.NBCASES + " cases, comportant : " + this.nbCasesSubvention + " cases 'Subvention', " + this.nbCasesRepos + " cases 'Repos', " +
                this.nbCasesBFP + " cases 'BFP', " + this.nbCasesAntitrust + " cases 'Antitrust', " + this.nbCasesInvestissement + " cases 'Investissement'";
    }

    public int getNBCASES(){
        return NBCASES;
    }

}
