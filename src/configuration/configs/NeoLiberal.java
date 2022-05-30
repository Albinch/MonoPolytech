package configuration.configs;

import configuration.Configuration;

public class NeoLiberal extends Configuration {

    public NeoLiberal(boolean foncier){
        setPourcentageTaxes(10);
        setLimiteAntiTrust(3000);
        setSubventions(1200);
        setFoncier(foncier);
    }

}
