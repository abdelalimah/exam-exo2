package figures;

public class Cercle extends Shape {

    private int x;
    private int y; 
    private int rayon;
    private final int value = 10;

    public Cercle(){
        this(10,30,50);
    }

    public Cercle(int x, int y,int rayon){
        super(x,y);
        this.rayon = rayon;
    }

    public int getValue() {
        return value;
    }
    
}
