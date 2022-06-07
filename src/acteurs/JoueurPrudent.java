package acteurs;

import exceptions.AntitrustException;
import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import plateau.*;
import configuration.*;
import investissement.ComparateurInvestissement;
import investissement.Investissement;

import static main.Main.CONFIG;
import static plateau.Plateau.ETAT;

public class JoueurPrudent extends Joueur{
    public JoueurPrudent(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException, AntitrustException {
        Configuration currentConfig = CONFIG.getCurrentConfig();
        float seuil = (this.getLiquide() + this.getValeurPatrimoine()) * 0.2F;

        if(this.getInvestissements().contains(investissement)){
            return;
        }

        if(investissement.getProprietaire().equals(ETAT)){
            if(this.getInvestissements().size() < currentConfig.getLimiteAntiTrust() && investissement.getValeur() <= seuil)
                this.acheter(investissement);
            else if(this.getInvestissements().size() == currentConfig.getLimiteAntiTrust())
                throw new AntitrustException();
            else if(investissement.getValeur() > this.getLiquide())
                throw new PasAssezDeLiquideException(0);
        }else
            this.payer(investissement.getProprietaire(), investissement);
    }

    public void actionAntitrust(){
        int nbInvestissements = this.getInvestissements().size();
        if(nbInvestissements < CONFIG.getCurrentConfig().getLimiteAntiTrust()){
            System.out.println("Ce joueur ne possède pas plus de biens que la limite (" + super.getInvestissements().size() + " <= " + CONFIG.getCurrentConfig().getLimiteAntiTrust() + "). Il ne doit rien vendre.\n");
        }
        else{
            this.vendre(this.getInvestissements().get(this.getInvestissements().size()-1));
        }
    }

    public String toString(){
        return super.toString() + "Comportement : prudent";
    }
}
