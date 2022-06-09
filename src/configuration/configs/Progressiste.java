package configuration.configs;

import configuration.Configuration;

public class Progressiste extends Configuration {

    public Progressiste(boolean foncier){
        setPourcentageTaxes(22);
        setLimiteAntiTrust(4);
        setSubventions(2500);
        setFoncier(foncier);
    }

    public void setJoueurs(){}

    @Override
    public String toString() {
        return "La configuration actuelle est 'Progressiste'";
    }

}
