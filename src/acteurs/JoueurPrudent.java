package acteurs;

import plateau.*;
import configuration.*;
import investissement.ComparateurInvestissement;
import investissement.Investissement;

public class JoueurPrudent extends Joueur{
    public JoueurPrudent(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement( Investissement investissement){
    Configuration currentConfig = Main.CONFIG.getCurrentConfig();
        if(this.getInvestissement().size()<currentConfig.getLimiteAntiTrust() || investissement.getValeur() < this.getLiquide()){
            this.acheter(investissement);
        }
        else if(this.getInvestissement().size()==currentConfig.getLimiteAntiTrust()){
            System.out.println("Le nombre maximum d'investissement est atteint pour ce joueur");
        }
        else if(investissement.getValeur() > this.getLiquide()){
            System.out.println("Ce investissement est trop chere");
        }
    }

    public void actionAntitrust(){
        
        this.getInvestissements().sort(new ComparateurInvestissement());
        if(nbInvestissements < Main.CONFIG.getCurrentConfig().getLimiteAntiTrust()){
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
