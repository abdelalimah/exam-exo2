package figures;

public class Ligne extends Shape {

    private int x;
    private int y;
    private final int value = 2;

    public Ligne(){
        this(10,30);
    }

    public Ligne(int x , int y){
        super(x,y);
    }

    public int getValue() {
        return value;
    }
}
