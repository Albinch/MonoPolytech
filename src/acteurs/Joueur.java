package acteurs;

import investissement.Investissement;
import plateau.*;
import exceptions.*;

import java.util.Random;

import static plateau.Plateau.*;

public abstract class Joueur extends Acteur implements StyleJoueur{

    private Case currentCase;

    public Joueur(float liquide, String nom, Case currentCase){
        super(liquide, nom);
        this.currentCase = currentCase;
    }

    public void setCurrentCase(Case c){
        this.currentCase = c;
    }

    public abstract void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException;

    public abstract void actionAntitrust();

    public void acheter(Investissement investissement) throws PasAssezDeLiquideException{
        if(this.getLiquide() < investissement.getValeur())
            throw new PasAssezDeLiquideException();
        this.getInvestissements().add(investissement);
        this.setLiquide(this.getLiquide() - investissement.getValeur());
        ETAT.getInvestissements().remove(investissement);
    }

    public void vendre(Investissement investissement){
        this.getInvestissements().remove(investissement);
        this.setLiquide(this.getLiquide() + investissement.getValeur());
        ETAT.getInvestissements().add(investissement);
    }

    public void payerBFP(boolean foncier, float taxe) throws PasAssezDeLiquideException{
        float valeur;
        if(foncier){
            valeur = this.getValeurPatrimoine();
            if(this.getLiquide() < valeur * taxe)
                throw new PasAssezDeLiquideException();
            else
                this.setLiquide(this.getLiquide() - valeur * taxe);
        }else{
            valeur = this.getValeurPatrimoine() + this.getLiquide();
            if(this.getLiquide() < valeur * taxe)
                throw new PasAssezDeLiquideException();
            else
                this.setLiquide(this.getLiquide() - valeur);
        }
    }

    public void recevoirSubvention(float subvention){
        this.setLiquide(this.getLiquide() + subvention);
    }

    public void jouer(){
        int valeurDe = new Random().nextInt(1, 6);
        this.setCurrentCase((CASES.get(this.currentCase.getIndex() + valeurDe % NBCASES)));
    }

    public void payer(Acteur acteur, Investissement investissement) throws PasAssezDeLiquideException{
        float utilite = investissement.getValeur() * investissement.getRentabilite();
        if(this.getLiquide() < utilite)
            throw new PasAssezDeLiquideException();
        this.setLiquide(this.getLiquide() - utilite);
        acteur.setLiquide(acteur.getLiquide() + utilite);
    }

    public String toString(){
        return this.toString() + ". Ce joueur est tombé sur la case : " + this.currentCase + "\n";
    }

    public Case getCurrentCase(){
        return this.currentCase;
    }

}