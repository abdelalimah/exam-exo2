package concurrent;

import java.util.concurrent.TimeUnit;

import figures.Shape;

public class Player extends Thread {

    private Screen screen;
    private int score = 0;
    private final int maxPoints = 100;
    private int winner;
    private Semaphore M;
    private Semaphore F;
       
    
    public Player(Screen screen,int winner,Semaphore M,Semaphore F){
        this.screen = screen;
        this.winner = winner;
        this.M = M;
        this.F = F;
    }

    @Override
    public void run() {
        
        while(winner < 1){
            int x = (int)(Math.random() * (100-0) ) + 0;
            int y = (int)(Math.random() * (100-0) ) + 0;
            
            F.waitDijkstra();
            
            M.waitDijkstra();
            Shape shape = screen.get(x, y);
            M.signalDijkstra();

            if(shape == null){
                try{
                    score -= 2;
                    TimeUnit.SECONDS.sleep(2);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }else {
                score++;
            }

            if(score >= maxPoints){
                System.out.println("Winner : "+Thread.currentThread().getName()+ ", Score : "+score);
                updateWinner();
                break;
            }
        }

    }

    public synchronized void updateWinner(){
        winner+=1;
    }

    public synchronized int getScore(){
        return score;
    }
    
}
