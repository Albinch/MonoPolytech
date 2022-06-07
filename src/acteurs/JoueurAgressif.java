package acteurs;

import exceptions.PasAssezDeLiquideException;
import investissement.ComparateurInvestissement;
import investissement.Investissement;
import plateau.*;

import static main.Main.CONFIG;

public class JoueurAgressif extends Joueur{
    public JoueurAgressif(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException {
        if(this.getLiquide() < investissement.getValeur())
            throw new PasAssezDeLiquideException();
        else
            this.acheter(investissement);
            System.out.println(super.getNom() + " a acheté le bien " + investissement.getNom() + ", d'une valeur de " + investissement.getValeur() + ".\nLiquide après achat : " + super.getLiquide());
    }

    public void actionAntitrust(){
        int nbInvestissements = this.getInvestissements().size();
        if(nbInvestissements < CONFIG.getCurrentConfig().getLimiteAntiTrust())
            System.out.println("Ce joueur ne possède pas plus de biens que la limite. Il ne doit rien vendre.\n");
        else{
            int investissementsAVendre = nbInvestissements - CONFIG.getCurrentConfig().getLimiteAntiTrust();
            this.getInvestissements().sort(new ComparateurInvestissement());
            for(int i = 0; i < investissementsAVendre; i++){
                this.vendre(this.getInvestissements().get(i));
            }
        }
    }

    public String toString(){
        return super.toString() + "Comportement : agressif";
    }
}
