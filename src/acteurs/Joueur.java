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

    public abstract void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException, AntitrustException;

    public abstract void actionAntitrust();

    public void acheter(Investissement investissement) throws PasAssezDeLiquideException{
        if(this.getLiquide() < investissement.getValeur()){
            throw new PasAssezDeLiquideException(investissement.getValeur() - this.getLiquide());
        }
        this.getInvestissements().add(investissement);
        investissement.setProprietaire(this);
        this.setLiquide(this.getLiquide() - investissement.getValeur());
        ETAT.getInvestissements().remove(investissement);
        System.out.println(this.getNom() + " a acheté le bien " + investissement.getNom());
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
        float utilite = investissement.getValeur() * (investissement.getRentabilite()/100);
        if(this.getLiquide() < utilite) {
            throw new PasAssezDeLiquideException(utilite - this.getLiquide());
        }else if(this.getLiquide() + this.getValeurPatrimoine() < utilite){
            throw new NePeutPasPayerException();
        }else{
            this.setLiquide(this.getLiquide() - utilite);
            acteur.setLiquide(acteur.getLiquide() + utilite);
            System.out.println(this.getNom() + " a payé " + acteur.getNom() + " " + utilite + "€ pour être tombé sur son investissement " + investissement.getNom());
        }
    }

    public void eliminer(){
        players.remove(this);
        System.out.println("Le joueur " + this.getNom() + " est éliminé de la partie.");
    }

    public void compenser(float resteAPayer){
        System.out.println("Il manque " + resteAPayer + "€ à " + this.getNom() + " pour payer la BFP. Il va devoir vendre des biens.");

        int montantRecolte = 0;

        while(montantRecolte < resteAPayer){
            if(this.getInvestissements().size() == 0){
                this.eliminer();
                return;
            }
            Investissement toSell = this.getInvestissements().get(0);
            montantRecolte += toSell.getValeur();
            this.vendre(toSell);
            System.out.println("- " + toSell.getNom() + " pour " + toSell.getValeur() + "€.");

            System.out.println(this.getNom() + " a vendu pour " + montantRecolte + "€.");
        }
    }

    public String toString(){
        return super.toString() + "Current case : " + getCurrentCase().toString();
    }

}