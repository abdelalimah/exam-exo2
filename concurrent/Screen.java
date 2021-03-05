package concurrent;

import java.util.concurrent.TimeUnit;

import figures.Shape;

public class Screen {
    private Shape[][] figures = new Shape[100][100];

    public Screen(){

    }

    public boolean put(Shape s){
        int x = (int)(Math.random() * (100-0) ) + 0;
        int y = (int)(Math.random() * (100-0) ) + 0;

        Shape currentCell = figures[1][2];
        if(currentCell == null){
            figures[x][y] = s;
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return true;
        }

        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Shape get(int x , int y){
        Shape currentCell = figures[x][y];
        try{    
            if(currentCell != null){
                TimeUnit.MILLISECONDS.sleep(500);
                figures[x][y] = null;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return currentCell;
    }
}
