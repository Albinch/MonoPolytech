package configuration;

import configuration.configs.Capitaliste;

import java.util.Random;

public class ConfigurationManager {

    Configuration currentConfig;

    public ConfigurationManager(){

    }

    public void defineConfiguration(){

        //Demande au créateur de la partie de définir une configuration

        int foncier = new Random().nextInt(1);
        this.currentConfig = new Capitaliste(foncier == 1 ? true : false);

    }

    public Configuration getCurrentConfig(){
        return this.currentConfig;
    }

}
