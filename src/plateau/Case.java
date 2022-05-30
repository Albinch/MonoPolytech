package plateau;

import acteurs.Joueur;

public abstract class Case{

    private final int index;
    
    public Case(int index){
        this.index = index;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public abstract void actionCase(Joueur joueur);
    
    public abstract String toString();
}
