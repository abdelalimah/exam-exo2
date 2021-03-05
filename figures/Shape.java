package figures;

public class Shape {

    private int x;
    private int y;
    private final int value = 10;

    public Shape(){
        this(10,30);
    }

    public Shape(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "x : "+x+" y : "+y;
    }
}
