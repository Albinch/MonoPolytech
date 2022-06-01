package acteurs;

import exceptions.PasAssezDeLiquideException;
import investissement.Investissement;

public interface StyleJoueur {
    public void actionInvestissement(Investissement investissement) throws PasAssezDeLiquideException;
    public void actionAntitrust();
}