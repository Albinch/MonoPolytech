package acteurs;

import exceptions.NePeutPasPayerException;
import exceptions.PasAssezDeLiquideException;
import investissement.ComparateurInvestissement;
import investissement.Investissement;
import plateau.*;

import static main.Main.CONFIG;

public class JoueurAgressif extends Joueur{
    public JoueurAgressif(float liquide, String nom, Case currentCase){
        super(liquide, nom, currentCase);
    }

    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException, NePeutPasPayerException {
        if(!this.getInvestissements().contains(investissement)){
            if(investissement.getProprietaire() instanceof Etat){
                this.acheter(investissement);
            }else{
                this.payer(investissement.getProprietaire(), investissement);
            }
        }else{
            System.out.println(this.getNom() + " est tombé sur un investissement qui était le sien.");
        }
    }

    public void actionAntitrust(){
        int nbInvestissements = this.getInvestissements().size();
        if(nbInvestissements < CONFIG.getCurrentConfig().getLimiteAntiTrust()) {
            System.out.println("Ce joueur ne possède pas plus de biens que la limite (" + super.getInvestissements().size() + " <= " + CONFIG.getCurrentConfig().getLimiteAntiTrust() + "). Il ne doit rien vendre.\n");
        }else{
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
