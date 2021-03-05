package figures;

public class Carre extends Shape {
    private int x;
    private int y;
    private int z;
    private int e;

    private final int value = 5;

    public Carre(){
        this(2,4,0,4);
    }

    public Carre(int x, int y , int z, int e){
        super(x,y);
        this.z = z;
        this.e = e;
    }

    public int getValue() {
        return value;
    }
}
