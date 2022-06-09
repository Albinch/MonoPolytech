package configuration.configs;

import configuration.Configuration;

public class Progressiste extends Configuration {

    public Progressiste(boolean foncier){
        setPourcentageTaxes(22);
        setLimiteAntiTrust(4);
        setSubventions(2500);
        setFoncier(foncier);
    }

    public void setJoueurs(){
        super.setJoueurs();
    }

    public void setProfitPercentage(){
        super.setProfitPercentage(1.2F);
    }

    @Override
    public String toString() {
        return "La configuration actuelle est 'Progressiste'";
    }

}
