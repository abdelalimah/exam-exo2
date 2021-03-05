 package concurrent;

import figures.Carre;
import figures.Cercle;
import figures.Ligne;
import figures.Pixel;
import figures.Shape;
import figures.Triangle;

public class Drawer extends Thread {
    
    private Screen screen;
    private Semaphore M;
    private Semaphore F;
    
    public Drawer(Screen screen,Semaphore M,Semaphore F){
        this.screen = screen;
        this.M = M;
        this.F = F;
    }

    @Override
    public void run() {
        Class<?>[] shapes = {Cercle.class,Carre.class,Ligne.class,Pixel.class,Shape.class,Triangle.class};
        while(true){
            int randomIndex = (int)(Math.random() * (shapes.length - 0)) + 0;
            try{
                Shape shape = (Shape)shapes[randomIndex].getDeclaredConstructor().newInstance();
                
                M.waitDijkstra();// mutual exclusion semaphore
                System.out.println("Drawing the shape : "+shape.getClass());
                screen.put(shape);// critical section
                M.signalDijkstra();

                F.signalDijkstra();

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
