package configuration.configs;

import configuration.Configuration;

public class Socialiste extends Configuration {

    public Socialiste(float pourcentageTaxes, float limiteAntiTrust, float subventions, boolean foncier){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
        setFoncier(foncier);
    }

}
