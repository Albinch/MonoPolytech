package configuration.configs;

import configuration.Configuration;

public class Europe extends Configuration {

    public Europe(float pourcentageTaxes, int limiteAntiTrust, float subventions, boolean foncier){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
        setFoncier(foncier);
    }

    public void setJoueurs(){}

    @Override
    public String toString() {
        return "La configuration actuelle est 'Europe'";
    }

}
