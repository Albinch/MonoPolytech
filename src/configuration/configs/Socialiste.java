package configuration.configs;

import configuration.Configuration;

public class Socialiste extends Configuration {

    public Socialiste(boolean foncier){
        setPourcentageTaxes(17);
        setLimiteAntiTrust(3);
        setSubventions(900);
        setFoncier(foncier);
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Socialiste'";
    }
}
