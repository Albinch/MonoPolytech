package configuration;

public abstract class Configuration {

    float pourcentageTaxes;
    int limiteAntiTrust;
    float subventions;
    boolean foncier;

    public boolean isFoncier() {
        return foncier;
    }

    public void setFoncier(boolean foncier) {
        this.foncier = foncier;
    }

    public float getPourcentageTaxes() {
        return pourcentageTaxes;
    }

    public void setPourcentageTaxes(float pourcentageTaxes) {
        this.pourcentageTaxes = pourcentageTaxes;
    }

    public int getLimiteAntiTrust() {
        return limiteAntiTrust;
    }

    public void setLimiteAntiTrust(int limiteAntiTrust) {
        this.limiteAntiTrust = limiteAntiTrust;
    }

    public float getSubventions() {
        return subventions;
    }

    public void setSubventions(float subventions) {
        this.subventions = subventions;
    }

    public abstract String toString();

}
