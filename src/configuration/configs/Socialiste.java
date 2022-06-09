package configuration.configs;

import configuration.Configuration;

public class Socialiste extends Configuration {

    public Socialiste(boolean foncier){
        setPourcentageTaxes(45);
        setLimiteAntiTrust(6);
        setSubventions(900);
        setFoncier(foncier);
    }

    public void setJoueurs(){}

    @Override
    public String toString() {
        return "La configuration actuelle est 'Socialiste'";
    }
}
