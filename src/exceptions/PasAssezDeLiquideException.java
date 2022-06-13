package exceptions;

public class PasAssezDeLiquideException extends JeuException{
    private float resteAPayer;

    public PasAssezDeLiquideException(float resteAPayer){
        this.resteAPayer = resteAPayer;
    }

    public float getRAP(){
        return this.resteAPayer;
    }
}
