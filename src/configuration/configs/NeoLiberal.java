package configuration.configs;

import configuration.Configuration;

public class NeoLiberal extends Configuration {

    public NeoLiberal(boolean foncier){
        setPourcentageTaxes(10);
        setLimiteAntiTrust(3);
        setSubventions(1200);
        setFoncier(foncier);
    }

    public void setJoueurs(){}

    @Override
    public String toString() {
        return "La configuration actuelle est 'Néo Libérale'";
    }

}
