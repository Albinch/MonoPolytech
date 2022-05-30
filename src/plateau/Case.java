package plateau;

import acteurs.Joueur;

public class Case{

    private final int index;
    
    public Case(int index){
    
        this.index = index;
        
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public void actionCase(Joueur joueur){
    
    //
    
    }
    
    public String toString() {
        return "la case '"+this.index;
    }
}
