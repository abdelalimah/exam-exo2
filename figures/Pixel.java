package figures;

public class Pixel extends Shape{

    private int x;
    private int y;
    private final int value = 1;

    public Pixel(){
        this(40,11);
    }

    public Pixel(int x , int y){
        super(x,y);
    }

    public int getValue() {
        return value;
    }
}
