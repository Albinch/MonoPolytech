package configuration.configs;

import configuration.Configuration;

public class Progressiste extends Configuration {

    public Progressiste(float pourcentageTaxes, float limiteAntiTrust, float subventions){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
    }

}
