package acteurs;

import exceptions.PasAssezDeLiquideException;
import plateau.*;
import configuration.*;
import investissement.ComparateurInvestissement;
import investissement.Investissement;

import static main.Main.CONFIG;

public class JoueurPrudent extends Joueur{
    public JoueurPrudent(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException {
        Configuration currentConfig = CONFIG.getCurrentConfig();
        if(this.getInvestissements().size()<currentConfig.getLimiteAntiTrust() || investissement.getValeur() < this.getLiquide()){
            this.acheter(investissement);
        }
        else if(this.getInvestissements().size()==currentConfig.getLimiteAntiTrust()){
            System.out.println("Le nombre maximum d'investissement est atteint pour ce joueur");
        }
        else if(investissement.getValeur() > this.getLiquide()){
            System.out.println("Ce investissement est trop chere");
        }
    }

    public void actionAntitrust(){
        int nbInvestissements = this.getInvestissements().size();
        if(nbInvestissements < CONFIG.getCurrentConfig().getLimiteAntiTrust()){
            System.out.println("Ce joueur ne possède pas plus de biens que la limite. Il ne doit rien vendre.\n");
        }
        else{
            this.vendre(this.getInvestissements().get(this.getInvestissements().size()-1));
        }
    }

    public String toString(){
        return super.toString() + "Il adoptera le comportement prudent";
    }
}
