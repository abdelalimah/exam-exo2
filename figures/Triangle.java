package figures;

public class Triangle extends Shape{

    private int x;
    private int y;
    private int z;
    private final int value = 8;

    public Triangle(){
        this(10,30,40);
    }

    public Triangle(int x,int y,int z){
        super(x,y);
        this.z = z;
    }

    @Override
    public int getValue() {
        return super.getValue();
    }
    
}
