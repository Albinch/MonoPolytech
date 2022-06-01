package configuration.configs;

import configuration.Configuration;

public class Capitaliste extends Configuration {

    public Capitaliste(boolean foncier){
        setPourcentageTaxes(45);
        setLimiteAntiTrust(3);
        setSubventions(2000);
        setFoncier(foncier);
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Capitaliste'";
    }

}
