package configuration.configs;

import configuration.Configuration;

public class Progressiste extends Configuration {

    public Progressiste(boolean foncier){
        setPourcentageTaxes(22);
        setLimiteAntiTrust(3);
        setSubventions(1000);
        setFoncier(foncier);
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Progressiste'";
    }

}
