package acteurs;

import investissement.Investissement;
import plateau.*;
import exceptions.*;

import java.util.Random;

import static plateau.Plateau.*;
import static main.Main.players;

public abstract class Joueur extends Acteur implements StyleJoueur{

    private Case currentCase;

    public Joueur(float liquide, String nom, Case currentCase){
        super(liquide, nom);
        this.currentCase = currentCase;
    }

    public Case getCurrentCase(){
        return this.currentCase;
    }

    public void setCurrentCase(Case c){
        this.currentCase = c;
    }

    public abstract void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException;

    public abstract void actionAntitrust();

    public void acheter(Investissement investissement) throws PasAssezDeLiquideException{
        if(this.getLiquide() < investissement.getValeur())
            throw new PasAssezDeLiquideException(investissement.getValeur() - this.getLiquide());
        this.getInvestissements().add(investissement);
        investissement.setProprietaire(this);
        this.setLiquide(this.getLiquide() - investissement.getValeur());
        ETAT.getInvestissements().remove(investissement);
    }

    public void vendre(Investissement investissement){
        this.getInvestissements().remove(investissement);
        this.setLiquide(this.getLiquide() + investissement.getValeur());
        ETAT.getInvestissements().add(investissement);
        investissement.setProprietaire(ETAT);
    }

    public void payerBFP(boolean foncier, float taxe) throws PasAssezDeLiquideException, NePeutPasPayerException{
        float valeur;
        taxe = taxe/100;

        valeur = foncier ? this.getValeurPatrimoine() : (this.getValeurPatrimoine() + this.getLiquide());

        if(this.getLiquide() + this.getValeurPatrimoine() < valeur * taxe)
            throw new NePeutPasPayerException();

        if(this.getLiquide() < valeur*taxe)
            throw new PasAssezDeLiquideException((valeur*taxe) - this.getLiquide());

        System.out.println(super.getNom() + " a payé " + (valeur*taxe) + "€ à la BFP. (Pris sur " + (foncier ? "patrimoine" : "liquide + patrimoine") + ")");
        this.setLiquide(this.getLiquide() - valeur * taxe);
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

    public void payer(Acteur acteur, Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException{
        float utilite = investissement.getValeur() * investissement.getRentabilite();
        if(this.getLiquide() < utilite) {
            throw new PasAssezDeLiquideException(utilite - this.getLiquide());
        }else if(this.getLiquide() + this.getValeurPatrimoine() < utilite){
            throw new NePeutPasPayerException();
        }else{
            this.setLiquide(this.getLiquide() - utilite);
            acteur.setLiquide(acteur.getLiquide() + utilite);
        }
    }

    public void eliminer(){
        players.remove(this);
        System.out.println("Le joueur " + this.getNom() + " est éliminé de la partie.");
    }

    public String toString(){
        return super.toString() + "Current case : " + getCurrentCase().toString();
    }

}