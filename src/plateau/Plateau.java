package plateau;

import investissement.Investissement;
import plateau.cases.*;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {

    private ArrayList<Case> cases;
    private int nbCases = 40;
    private int nbCasesAntitrust = 6;
    private int nbCasesBFP = 4;
    private int nbCasesRepos = 10;
    private int nbCasesSubvention = 10;

    public Plateau(int nbCases){
        this.nbCases = nbCases;
        this.cases = new ArrayList<Case>();
    }

    public void generatePlateau(){

        int i = 0;

        while(this.cases.size() < this.nbCases){
            int random = new Random().nextInt(5);
            switch(random){

                case 0:
                    this.cases.add(new Antitrust(i));
                    break;
                case 1:
                    this.cases.add(new BureauFinancesPubliques(i));
                    break;
                case 2:
                    this.cases.add(new CaseInvestissement(i, new Investissement("Test", 1000, 12)));
                    break;
                case 3:
                    this.cases.add(new Repos(i));
                    break;
                case 4:
                    this.cases.add(new Subvention(i));
                    break;

            }
        }
    }

}
