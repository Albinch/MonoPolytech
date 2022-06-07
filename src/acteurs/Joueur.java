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
        taxe = taxe/100;

        valeur = foncier ? this.getValeurPatrimoine() : (this.getValeurPatrimoine() + this.getLiquide());

        if(this.getLiquide() < valeur*taxe){
            throw new PasAssezDeLiquideException();
        }else{
            System.out.println(super.getNom() + " a payé " + (valeur*taxe) + "€ à la BFP. (Pris sur " + (foncier ? "patrimoine" : "liquide + patrimoine") + ")");
            this.setLiquide(this.getLiquide() - valeur * taxe);
        }
    }

    public void recevoirSubvention(float subvention){
        System.out.println("A reçu une subvention (" + this.getLiquide() + " + " + subvention + " = " + (this.getLiquide()+subvention) + ")");
        this.setLiquide(this.getLiquide() + subvention);
    }

    public int jouer(){
        int valeurDe = new Random().nextInt(1, 6);
        int supposed = (this.currentCase.getIndex() + valeurDe) % NBCASES;
        System.out.println("Supposed: " + supposed);
        this.setCurrentCase((CASES.get(supposed)));
        return valeurDe;
    }

    public void payer(Acteur acteur, Investissement investissement) throws PasAssezDeLiquideException{
        float utilite = investissement.getValeur() * investissement.getRentabilite();
        if(this.getLiquide() < utilite) {
            throw new PasAssezDeLiquideException();
        }
        this.setLiquide(this.getLiquide() - utilite);
        acteur.setLiquide(acteur.getLiquide() + utilite);
    }

    public String toString(){
        return super.toString() + "Current case : " + getCurrentCase().toString();
    }

    public Case getCurrentCase(){
        return this.currentCase;
    }

}