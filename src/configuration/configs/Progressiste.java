package configuration.configs;

import configuration.Configuration;

public class Progressiste extends Configuration {

    public Progressiste(boolean foncier){
        setPourcentageTaxes(22);
        setLimiteAntiTrust(4000);
        setSubventions(1000);
        setFoncier(foncier);
    }

}
