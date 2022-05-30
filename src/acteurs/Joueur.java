package acteurs;

import com.sun.tools.javac.Main;
import investissement.Investissement;
import plateau.*;
import exceptions.*;

public abstract class Joueur extends Acteur implements StyleJoueur{

    private Case currentCase;

    public Joueur(float liquide, String nom, Case currentCase){
        super(liquide, nom);
        this.currentCase = currentCase;
    }

    public abstract void actionInvestissement();

    public abstract void actionAntitrust();

    public void acheter(Investissement investissement) throws PasAssezDeLiquideException{
        if(super.getLiquide() < investissement.getValeur())
            throw new PasAssezDeLiquideException();
        super.getInvestissements().add(investissement);
        super.setLiquide(super.getLiquide() - investissement.getValeur());
    }

    public void vendre(Investissement investissement){
        super.getInvestissements().remove(investissement);
        super.setLiquide(super.getLiquide() + investissement.getValeur());
    }

    public void payerBFP(){

    }

    public void recevoirSubvention(){

    }

    public void jouer(){

    }

    public void payer(Acteur acteur, Investissement investissement) throws PasAssezDeLiquideException{
    }

    public String toString(){
        return super.toString() + ". Ce joueur est tombé sur la case : " + this.currentCase + "\n";
    }
}