package configuration.configs;

import configuration.Configuration;

public class Europe extends Configuration {

    public Europe(float pourcentageTaxes, float limiteAntiTrust, float subventions, boolean foncier){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
        setFoncier(foncier);
    }

}
