package configuration.configs;

import configuration.Configuration;

public class Capitaliste extends Configuration {

    public Capitaliste(float pourcentageTaxes, float limiteAntiTrust, float subventions){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
    }

}
