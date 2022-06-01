package investissement;

import java.util.Comparator;

public class ComparateurInvestissement implements Comparator<Investissement>{
    public int compare(Investissement i1, Investissement i2){
        if(i1.getValeur() < i2.getValeur())
            return -1;
        else if(i1.getValeur() == i2.getValeur())
            return 0;
        else
            return 1;
    }
}
