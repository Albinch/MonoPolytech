package configuration;

public abstract class Configuration {

    float pourcentageTaxes;
    float limiteAntiTrust;
    float subventions;

    public float getPourcentageTaxes() {
        return pourcentageTaxes;
    }

    public void setPourcentageTaxes(float pourcentageTaxes) {
        this.pourcentageTaxes = pourcentageTaxes;
    }

    public float getLimiteAntiTrust() {
        return limiteAntiTrust;
    }

    public void setLimiteAntiTrust(float limiteAntiTrust) {
        this.limiteAntiTrust = limiteAntiTrust;
    }

    public float getSubventions() {
        return subventions;
    }

    public void setSubventions(float subventions) {
        this.subventions = subventions;
    }

}
