package configuration.configs;

import configuration.Configuration;

public class NeoLiberal extends Configuration {

    public NeoLiberal(float pourcentageTaxes, float limiteAntiTrust, float subventions){
        setPourcentageTaxes(pourcentageTaxes);
        setLimiteAntiTrust(limiteAntiTrust);
        setSubventions(subventions);
    }

}
